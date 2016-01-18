package com.pipipark.j.mvc.server.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipipark.j.mvc.PPPMvcController;
import com.pipipark.j.system.core.PPPString;
import com.pipipark.j.system.core.PPPVersion;
import com.pipipark.j.system.entity.PPPEntity;


/***
 * 版本控制器,
 * 处理所有http请求.
 * @author pipipark:cwj
 */
@SuppressWarnings("serial")
@RestController("SpringMvcControllerHandler")
public class SpringMvcControllerHandler extends PPPEntity implements PPPMvcController {
	
	@Autowired
	private SpringMvcServiceHandler springMvcServiceHandler;
	
	@SuppressWarnings("unused")
	@RequestMapping("/service/{name}")
	public String service(@PathVariable("name") String serviceName, HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		String[] serviceNameTemp = PPPString.split(serviceName, ".");
		String service = null;
		PPPVersion version = null;
		//断言serviceNameTemp是否空.
		
		//断言serviceNameTemp[0]是否空.
		
		try{
			version = PPPVersion.get(serviceNameTemp[1]);
		}catch(ArrayIndexOutOfBoundsException e){
			version = PPPVersion.Rat;
		}
		
//		return springMvcServiceHandler.access(serviceName, ver==null?1:ver, request, response);
		return "";
	}
	
	@RequestMapping("/{entity}/{method}")
	public String entity(@PathVariable("name") String serviceName, HttpServletRequest request, HttpServletResponse response){
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
