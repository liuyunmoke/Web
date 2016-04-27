package com.pipipark.j.account.mouse.test;

import com.pipipark.j.mvc.core.PPPResonpse;

@SuppressWarnings("serial")
public class TestResponse extends PPPResonpse {

	private String testName;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
}
