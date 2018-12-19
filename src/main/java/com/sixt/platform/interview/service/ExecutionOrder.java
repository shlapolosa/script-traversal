package com.sixt.platform.interview.service;

public class ExecutionOrder {

	public String run(VulnerabilityScript vulnerabilityScript) {
		if (vulnerabilityScript.getDependencies().isEmpty()) {
			return String.valueOf(vulnerabilityScript.getScriptId());
		}
		return null;
	}
}
