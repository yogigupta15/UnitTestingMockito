package com.skillsoft.mocks;

public class DataPreparer {
	
	private String rawDataUrl;
	
	public DataPreparer(String rawDataUrl) {
		
		this.rawDataUrl = rawDataUrl;
	}
	
	public boolean prepareRawData() {
		
		//Note: Assume this method prepares the raw data needed to run the batch job by copying data to the temporary
		// locations for processing, and performing other pre-processing tasks.
		
		return true;
	}
}
