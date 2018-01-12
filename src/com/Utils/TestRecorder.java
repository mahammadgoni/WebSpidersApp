package com.Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class TestRecorder {
		
	ATUTestRecorder recorder;
	
	String videoDir = "IDBRecordedTest";
	
	public void StartRecord() throws ATUTestRecorderException{
		
		System.out.println("===============================================");
		
		System.out.println("Screen Recording Started");
		
		new File(videoDir).mkdir();
		
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		
		Date date = new Date();
		
		recorder = new ATUTestRecorder("IDBRecordedTest", "IDBTestRecording-"+ dateFormat.format(date), false);
		
		recorder.start();
	
		
	}
	
	public void StopRecord() throws ATUTestRecorderException{
		
		System.out.println("=================================================");
		
		System.out.println("Screen Recording Stopped");
		
		recorder.stop();
	}


}
