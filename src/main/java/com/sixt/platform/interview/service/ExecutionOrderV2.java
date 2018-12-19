package com.sixt.platform.interview.service;

/**
 * in the second version, execute the last scripts first and for each scritp, execute its
 * dependencies first
 *
 * Note! does not explicitly check for cyclic dependencies, nor does it have a
 * guard clause which would check for null or if a certain script had already been ran
 *
 *
 */
public class ExecutionOrderV2 {

	public String run(VulnerabilityScriptV2 vulnerabilityScript) {

		String result = String.valueOf(vulnerabilityScript.getScriptId());
		for (VulnerabilityScriptV2 script :vulnerabilityScript.getDependencies()) {
			result = run(script)+","+result;
		}
		return result;
	}
}

