package com.pipipark.j.mvc.server.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipipark.j.mvc.PPPMvcController;
import com.pipipark.j.mvc.core.PPPSpring;
import com.pipipark.j.system.core.PPPString;
import com.pipipark.j.system.entity.PPPEntity;



/***
 * 版本控制器,
 * 处理所有http外部请求.
 * 格式: 
 * @author pipipark:cwj
 */
@SuppressWarnings("serial")
@RestController("SpringMvcControllerHandler")
public class SpringMvcControllerHandler extends PPPEntity implements PPPMvcController {
	
	@Autowired
	private SpringMvcServiceHandler springMvcServiceHandler;
	
	@RequestMapping("/access:{service}/**")
	public String access(@PathVariable("service") String service, HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath();
		String[] pathParam = PPPString.split(path, "/");	
		
		for (String param : pathParam) {
			System.out.println(param);
		}
//		return springMvcServiceHandler.access(serviceName, ver==null?1:ver, request, response);
		return "";
	}

	@Override
	public void desc(StringBuilder string) throws Exception {
		
	}
}
