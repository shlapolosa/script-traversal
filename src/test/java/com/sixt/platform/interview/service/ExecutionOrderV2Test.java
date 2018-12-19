package com.sixt.platform.interview.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ExecutionOrderV2Test {

	ExecutionOrderV2 executionOrderV2;

	@Before
	public void setUp() throws Exception {
		executionOrderV2 = new ExecutionOrderV2();

	}

	@Test
	/**
	 * 1
	 */
	public void should_return_scriptId_when_script_has_no_dependencies() {
		Assert.assertEquals("1", executionOrderV2.run(new VulnerabilityScriptV2(1, new ArrayList<VulnerabilityScriptV2>())));
	}

	@Test
	/**
	 * 1 -> 2
	 */
	public void should_return_first_dependency_if_only_one_then_current_script_id() {
		ArrayList<VulnerabilityScriptV2> dependencies = new ArrayList<VulnerabilityScriptV2>();
		dependencies.add(new VulnerabilityScriptV2(2, new ArrayList<VulnerabilityScriptV2>()));
		Assert.assertEquals("2,1", executionOrderV2.run(new VulnerabilityScriptV2(1, dependencies)));


	}

	@Test
	/**
	 * 1 -> 2 -> 3
	 */
	public void should_return_dependencies_in_ascending_order() {
		ArrayList<VulnerabilityScriptV2> dependencies1 = new ArrayList<VulnerabilityScriptV2>();
		dependencies1.add(new VulnerabilityScriptV2(3, new ArrayList<VulnerabilityScriptV2>()));

		ArrayList<VulnerabilityScriptV2> dependencies = new ArrayList<VulnerabilityScriptV2>();
		dependencies.add(new VulnerabilityScriptV2(2, dependencies1));
		Assert.assertEquals("3,2,1", executionOrderV2.run(new VulnerabilityScriptV2(1, dependencies)));


	}

	@Test
	/**
	 *   1  -> 2 -> 4
	 *         |
	 *         -> 3
	 */
	public void should_do_a_depth_first_traversal_of_the_dependencies() {
		ArrayList<VulnerabilityScriptV2> dependencies1 = new ArrayList<VulnerabilityScriptV2>();
		dependencies1.add(new VulnerabilityScriptV2(3, new ArrayList<VulnerabilityScriptV2>()));

		ArrayList<VulnerabilityScriptV2> dependencies = new ArrayList<VulnerabilityScriptV2>();
		dependencies.add(new VulnerabilityScriptV2(2, dependencies1));
		dependencies.add(new VulnerabilityScriptV2(4, new ArrayList<VulnerabilityScriptV2>()));
		Assert.assertEquals("4,3,2,1", executionOrderV2.run(new VulnerabilityScriptV2(1, dependencies)));


	}
}
