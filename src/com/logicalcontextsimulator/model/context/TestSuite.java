package com.logicalcontextsimulator.model.context;

import java.util.List;

public class TestSuite {
	private List<AbstractContext> testCases;

	public void setTestCases(List<AbstractContext> testCases) {
		this.testCases = testCases;
	}

	public List<AbstractContext> getTestCases() {
		return testCases;
	}
}
