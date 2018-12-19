package com.sixt.platform.interview.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ExecutionOrderV1Test {

	ExecutionOrderV1 executionOrderV1;

	@Before
	public void setUp() throws Exception {
		executionOrderV1 = new ExecutionOrderV1();

	}

	@Test
	public void should_return_scriptId_when_script_has_no_dependencies() {
		Assert.assertEquals("1", executionOrderV1.run(new VulnerabilityScript(1, new ArrayList<Integer>())));
	}

	@Test
	public void should_return_first_dependency_if_only_one_then_current_script_id() {
		ArrayList<Integer> dependencies = new ArrayList<Integer>();
		dependencies.add(2);
		Assert.assertEquals("2,1", executionOrderV1.run(new VulnerabilityScript(1, dependencies)));


	}

	@Test
	public void should_return_dependencies_in_ascending_order() {
		ArrayList<Integer> dependencies = new ArrayList<Integer>();
		dependencies.add(2);
		dependencies.add(3);
		Assert.assertEquals("3,2,1", executionOrderV1.run(new VulnerabilityScript(1, dependencies)));


	}
}
