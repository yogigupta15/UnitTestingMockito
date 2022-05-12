package com.skillsoft.mocks;

public class WeeklyReportsBatchJob {
	
	private ResourceProvisioner resourceProvisioner;
	private DataPreparer dataPreparer;
	private EmailSender emailSender;
	
	public WeeklyReportsBatchJob() {
		
	}
/*	public void setResourceProvisioner(ResourceProvisioner resourceProvisioner) {
		
		this.resourceProvisioner = resourceProvisioner;
	}
	
	public void setDataPreparer(DataPreparer dataPreparer) {
		
		this.dataPreparer = dataPreparer;
	}
	
	public void setEmailSender(EmailSender emailSender) {
		
		this.emailSender = emailSender;
	}
*/	
	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
		
		//Note: Assume that this runs some kind of batch job to prepare and generate weekly reports and then sends an update
	   // to the email recipient that the weekly report has been generated.
		
		if(resourceProvisioner.setupCluster(3, "Windows 10", "Spark") && dataPreparer.prepareRawData()) {
			
			return emailSender.sendEmail(
					emailRecipient,
					String.format("The %s weekly report has been generated", reportType));
		}
		
		return false;
	}
	
	public boolean sendWeeklyReport(String reportType, String emailRecipient) {
		
		//Note: Assume that this runs some kind of batch job to prepare and generate weekly reports and then sends a copy of
	   // weekly report to the email recipient.
		
		if(resourceProvisioner.setupSingleMachine("Windows 10", "Java") && dataPreparer.prepareRawData()) {
			
			String reportCopy = "Sales have been going up!";
			
			return emailSender.sendEmailWithAttachment(
					emailRecipient, 
					String.format("The %s weekly report has been generated", reportType),
					reportCopy.getBytes());
		}
		
		return false;
	}
}
