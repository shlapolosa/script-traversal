package com.sixt.platform.interview.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ExecutionOrderTest {

	@Test
	public void should_return_scriptId_when_script_has_no_dependencies() {
		ExecutionOrder executionOrder = new ExecutionOrder();
		Assert.assertEquals("1",executionOrder.run(new VulnerabilityScript(1, new ArrayList<Integer>())));
	}
}
