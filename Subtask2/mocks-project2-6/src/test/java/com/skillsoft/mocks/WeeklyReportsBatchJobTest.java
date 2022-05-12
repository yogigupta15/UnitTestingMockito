package com.skillsoft.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeeklyReportsBatchJobTest {
	
	/* Using verify() to verify method invocations and using verifyNoInteractions() Function*/
	
	@Mock
	private EmailSender emailSenderMock;
	
	@Mock
	private ResourceProvisioner resourceProvisionerMock;
	
	@Mock
	private DataPreparer dataPreparerMock;
	
	@InjectMocks
	WeeklyReportsBatchJob batchJob;
	
	@Test
	public void testInitialize() {
		batchJob.initialize();
		
		verify(resourceProvisionerMock).initialize();
		verify(dataPreparerMock).initialize();
		
		verifyNoInteractions(emailSenderMock);
	}
	
	@Test
	public void testGenerateWeeklyReport(){
		
		when(resourceProvisionerMock.setupCluster(4,"Windows","Spark")).thenReturn(true);
		
		when(dataPreparerMock.prepareRawData()).thenReturn(true);
		
		when(emailSenderMock.sendEmail("john@infomoto.com",
				"The Sales weekly report has been generated")).thenReturn(true);
		
		batchJob.initialize();
		batchJob.initializeReportGenerationConfig(4, "Windows", "Spark");
		batchJob.generateWeeklyReport("Sales", "john@infomoto.com");
		
		verify(resourceProvisionerMock).initialize();
		
		verify(resourceProvisionerMock).setupCluster(4, "Windows", "Spark");
		
		verify(dataPreparerMock).initialize();
		verify(dataPreparerMock).prepareRawData();
		
		verify(emailSenderMock).sendEmail("john@infomoto.com",
				"The Sales weekly report has been generated");
	}
	
	@Test
	public void sendWeeklyReport_withAttachment() {
		
		when(resourceProvisionerMock.setupSingleMachine("Linux", "Java")).thenReturn(true);
		
		when(dataPreparerMock.prepareRawData()).thenReturn(true);
		
		when(emailSenderMock.sendEmailWithAttachment(
				"john@infomoto.com", 
				"The Profits weekly report has been generated", 
				"Sales have been going up!".getBytes())).thenReturn(true);
		
		batchJob.initialize();
		batchJob.initializeReportSendingConfig("Linux", "Java");
		batchJob.sendWeeklyReport("Profits", "john@infomoto.com");
		
		verify(resourceProvisionerMock).initialize();
		
		verify(resourceProvisionerMock).setupSingleMachine("Linux", "Java");
		
		verify(dataPreparerMock).initialize();
		verify(dataPreparerMock).prepareRawData();
		
		verify(emailSenderMock).sendEmailWithAttachment(
				"john@infomoto.com", 
				"The Profits weekly report has been generated", 
				"Sales have been going up!".getBytes());
	}
}
