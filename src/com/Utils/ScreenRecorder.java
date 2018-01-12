package com.Utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ScreenRecorder {
	
	
	private static List<String> ADBProcessIDsBeforeScreenRecording = null;
	 private static List<String> ADBProcessIDsAfterScreenRecording = null;


	 public static void StartScreenRecording(String CurrentTestMethodName)throws IOException {


	  // Storing all ADB process ids before starting Screen Recording.
	  ADBProcessIDsBeforeScreenRecording = getProcessIDs("adb.app");


	  // "Starting Screen Recording for Current TestMethod.
	  Runtime.getRuntime().exec("cmd /c adb shell screenrecord --bit-rate 1000000 //sdcard//"+ CurrentTestMethodName + ".mp4");


	 }


	 public static void StopScreenRecording(String CurrentTestMethodName,String DirectoryToSaveRecordedScreen,boolean RemoveRecordedScreenFromDevice) throws IOException,InterruptedException {

     // Creating directory to store the video
		 
		 String RecordedTest = DirectoryToSaveRecordedScreen;
		 
		 new File(RecordedTest).mkdir();
		 
		 System.out.println("Video Directory Crteated");
		 
		 
	  // Storing all ADB process ids after Screen Recording.
	  ADBProcessIDsAfterScreenRecording = getProcessIDs("adb.app");


	  // killing ADB task using process id.
	  // First we are trying to get ADB process id that is started due to ADB
	  // screenrecord then killing the same.
	  for (String id : ADBProcessIDsAfterScreenRecording) {
	   boolean found = false;
	   for (String tgtid : ADBProcessIDsBeforeScreenRecording) {
	    if (tgtid.equals(id)) {
	     found = true;
	     break;
	    }
	   }
	   if (!found) {
	    Runtime.getRuntime().exec("taskkill /F /PID " + id);
	    break;
	   }
	  }


	  // Sleep time to save the recorded video in Device properly
	  Thread.sleep(2000);


	  // Pulling Screen Recording to PC/Machine
	  Runtime.getRuntime().exec("cmd /c adb pull //sdcard//" + CurrentTestMethodName + ".mp4 "+ DirectoryToSaveRecordedScreen);
	  // Sleep time to pull video from device to destination directory
	  Thread.sleep(5000);


	  if (RemoveRecordedScreenFromDevice) {
	   // Deleting ScreenRecord from Device
	   Runtime.getRuntime().exec("cmd /c adb shell rm //sdcard//" + CurrentTestMethodName + ".mp4");
	  }


	 }


	 //Method to get List of Process Ids using Process Name
	 static List<String> getProcessIDs(String processName) {
	  List<String> processIDs = new ArrayList<String>();
	  try {
	   String line;
	   Process p = Runtime.getRuntime().exec("tasklist /v /fo csv");
	   BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	   while ((line = input.readLine()) != null) {
	    if (!line.trim().equals("")) {
	     // Pid is after the 1st ", thus it's argument 3 after splitting
	     String currentProcessName = line.split("\"")[1];
	     // Pid is after the 3rd ", thus it's argument 3 after splitting
	     String currentPID = line.split("\"")[3];
	     if (currentProcessName.equalsIgnoreCase(processName)) {
	      processIDs.add(currentPID);
	     }
	    }
	   }
	   input.close();
	  } catch (Exception err) {
	   err.printStackTrace();
	  }
	  return processIDs;
	 }
	

}
