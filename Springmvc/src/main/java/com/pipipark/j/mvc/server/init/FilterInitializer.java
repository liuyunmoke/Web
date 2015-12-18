package com.pipipark.j.mvc.server.init;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.FilterRegistration.Dynamic;

import org.springframework.core.Conventions;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import com.pipipark.j.mvc.PPPMvcInitializer;
import com.pipipark.j.mvc.scaner.PPPFilterScaner;
import com.pipipark.j.system.classscan.v2.PPPScanerManager;
import com.pipipark.j.system.core.PPPCollection;
import com.pipipark.j.system.core.PPPLogger;
import com.pipipark.j.system.core.PPPString;

@SuppressWarnings("serial")
@Order(3)
public class FilterInitializer implements WebApplicationInitializer,PPPMvcInitializer {

	@SuppressWarnings("unchecked")
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		PPPLogger.systemInfo("Filter initializer");

		// 扫描项目中所有过滤器.
		PPPFilterScaner scaner = (PPPFilterScaner)PPPScanerManager.scaner(PPPString.lowFirst(PPPString.className(PPPFilterScaner.class)));
		Set<Filter> filters = (Set<Filter>)scaner.data();

		// 装载
		if (!PPPCollection.isEmpty(filters)) {
			for (Filter filter : filters) {
				registerServletFilter(servletContext, filter);
			}
		}
	}

	private void registerServletFilter(ServletContext servletContext,
			Filter filter) {
		String filterName = Conventions.getVariableName(filter);
		Dynamic registration = servletContext.addFilter(filterName, filter);
		if (registration == null) {
			int counter = -1;
			while (counter == -1 || registration == null) {
				counter++;
				registration = servletContext.addFilter(filterName + "#"
						+ counter, filter);
				Assert.isTrue(
						counter < 100,
						"Failed to register filter '"
								+ filter
								+ "'."
								+ "Could the same Filter instance have been registered already?");
			}
		}
		registration.setAsyncSupported(true);
		registration.addMappingForServletNames(getDispatcherTypes(), false,
				AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME);
	}

	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,
				DispatcherType.INCLUDE, DispatcherType.ASYNC);
	}
}
