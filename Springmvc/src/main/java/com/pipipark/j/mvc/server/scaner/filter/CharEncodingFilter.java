package com.pipipark.j.mvc.server.scaner.filter;

import org.springframework.web.filter.CharacterEncodingFilter;

import com.pipipark.j.mvc.PPPMvcFilter;
import com.pipipark.j.system.annotation.PPPIndex;
import com.pipipark.j.system.classscan.v2.PPPInitMethod;
import com.pipipark.j.system.core.PPPConstant;

@SuppressWarnings("serial")
@PPPIndex(PPPConstant.Indexs.HIGHEST_INDEX)
public class CharEncodingFilter extends CharacterEncodingFilter implements
		PPPMvcFilter, PPPInitMethod<CharacterEncodingFilter> {

	@Override
	public void init_method(CharacterEncodingFilter t) {
		t.setEncoding("UTF-8");
		t.setForceEncoding(true);
	}

}
