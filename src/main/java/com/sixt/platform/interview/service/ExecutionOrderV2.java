package com.sixt.platform.interview.service;

/**
 * in the second version, execute the last scripts first and for each scritp, execute its
 * dependencies first
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

