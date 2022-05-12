package com.skillsoft.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeeklyReportsBatchJobTest {
	
	/* Using @ExtendWith Annotation and Working with The @InjectMocks Annotation */
	
	@Mock
	private EmailSender emailSenderMock;
	
	@InjectMocks
	WeeklyReportsBatchJob batchJob;
	
	@Test
	public void testGenerateWeeklyReport_singleRecipient() {
		
		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
		assertTrue(batchJob.generateWeeklyReport("Sales", "john@infomoto.com"));
	}
	
	@Test
	public void testGenerateWeeklyReport_multipleRecipients() {
				
		when(emailSenderMock.sendEmailToMultipleRecipients(
				new String[] {"john@infomoto.com","julia@infomoto.com"},
				"The Revenues weekly report has been generated")).thenReturn(true);
		
		assertTrue(batchJob.generateWeeklyReport(
				"Revenues", new String[] {"john@infomoto.com","julia@infomoto.com"}));
	}
	
	@Test
	public void sendWeeklyReport_withAttachmrnt() {
		
		when(emailSenderMock.sendEmailWithAttachment(
				"john@infomoto.com",
				"The Profits weekly report has been generated",
				"Sales have been going up!".getBytes())).thenReturn(true);
		
		assertTrue(batchJob.sendWeeklyReport("Profits", "john@infomoto.com"));
	}
}
