package com.skillsoft.mocks;

public class ResourceProvisioner {
	
	private String cloudPlatform;
	private String authenticationKey;
	
	public ResourceProvisioner(String cloudPlatform, String authenticationKey) {
		
		this.cloudPlatform = cloudPlatform;
		this.authenticationKey = authenticationKey;
	}
	
	public void initialize() {
		//Note: Assume this method does some initialization for this class.
	}
	
	public boolean setupMachine(String operatingSystem, String framework) {
		
		//Note: Assume this makes the right calls to set up a single machine,installs the operating system,
		// and installs the software packages on the machine .
		
		return true;
	}
}
