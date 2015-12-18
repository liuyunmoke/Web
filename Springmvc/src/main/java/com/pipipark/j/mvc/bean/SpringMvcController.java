package com.pipipark.j.mvc.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipipark.j.mvc.PPPMvcController;
import com.pipipark.j.mvc.core.PPPContext;
import com.pipipark.j.system.entity.PPPEntity;



/***
 * 默认控制器,
 * 处理所有http外部请求.
 * 格式: 
 * @author pipipark:cwj
 */
@SuppressWarnings("serial")
@RestController("SpringMvcController")
public class SpringMvcController extends PPPEntity implements PPPMvcController {
	
	@RequestMapping("/{service}/{ver}")
	public String access(@PathVariable("service") String service, @PathVariable("ver") Integer ver, HttpServletRequest request, HttpServletResponse response){
		
		return null;
	}

	@Override
	public void desc(StringBuilder string) throws Exception {
		
	}
}
