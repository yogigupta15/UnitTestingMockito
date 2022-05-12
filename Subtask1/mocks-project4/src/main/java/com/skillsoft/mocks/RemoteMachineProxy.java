package com.skillsoft.mocks;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteMachineProxy {
	
	private final String remoteUrl;
	private Iterator<String> remoteFileIterator;
	
	public RemoteMachineProxy(String remoteUrl) {
		
		this.remoteUrl = remoteUrl;
	}
	
	private void connect() {
		
	}
	
	void setTestIterator(Iterator<String> testIterator) {
		this.remoteFileIterator = testIterator;
	}
	
	public String getNextFile() {
		if(remoteFileIterator.hasNext()) {
			String record = remoteFileIterator.next();
			Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(record);
			
			if(m.find()) {
				return m.group();
			}
			return remoteFileIterator.next();
		}
		return null;
	}
}
