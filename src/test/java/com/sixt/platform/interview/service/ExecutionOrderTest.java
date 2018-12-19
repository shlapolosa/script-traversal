package com.sixt.platform.interview.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ExecutionOrderTest {

	@Test
	public void should_return_null_on_empty_list() {
		ExecutionOrder executionOrder = new ExecutionOrder();
		Assert.assertNull(executionOrder.run(new VulnerabilityScript(1, new ArrayList<Integer>())));

	}

}
