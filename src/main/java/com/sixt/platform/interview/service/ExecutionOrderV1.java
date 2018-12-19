package com.sixt.platform.interview.service;

import java.util.Comparator;

/**
 * in the first version, just execute the scripts in the given order and make two
 * assumptions;
 *
 * 1. inserted in the intended order of dependency into the database
 * 2. no transitive dependencies i.e no scenerio where 1 depends on 2 which depends on 3
 * instead assuming we first need to run 3 then 2 then 1 which is a flat structure
 *
 */
public class ExecutionOrderV1 {

	public String run(VulnerabilityScript vulnerabilityScript) {

		String result = String.valueOf(vulnerabilityScript.getScriptId());
		for (int scriptId :vulnerabilityScript.getDependencies()) {
			result = scriptId+","+result;
		}
		return result;
	}
}

