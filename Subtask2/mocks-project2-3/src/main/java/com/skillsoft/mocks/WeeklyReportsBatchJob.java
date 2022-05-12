package com.skillsoft.mocks;

public class WeeklyReportsBatchJob {
	
	private EmailSender emailSender;
	
	public WeeklyReportsBatchJob(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
	
	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
		
		//Note: Assume that this run some kind of batch job to prepare and generate weekly reports and then
		// sends an update to the email recipient that the weekly report has been generated .   
		
		return emailSender.sendEmail(
				emailRecipient, 
				String.format("The %s weekly report has been generated", reportType));
	}
	
	public boolean generateWeeklyReport(String reportType, String[] emailRecipients) {
		
		//Note: Assume that this runs some kind of batch job to prepare and generate weekly reports and then
		// sends a copy of the weekly report to multiple email recipients . 
		
		String reportCopy = "Sales have been going up!";
				
		return emailSender.sendEmailToMultipleRecipients(
				emailRecipients,
				String.format("The %s weekly report has been generated", reportType));
	}
	
	public boolean sendWeeklyReport(String reportType, String emailRecipient) {
		
		//Note: Assume that this runs some kind of batch job to prepare and generate weekly reports and then
		// sends a copy of the weekly report to multiple email recipients . 
		
		String reportCopy = "Sales have been going up!";
		
		return emailSender.sendEmailWithAttachment(
				emailRecipient, 
			    String.format("The %s weekly report has been generated", reportType),
				reportCopy.getBytes());
	}
}
