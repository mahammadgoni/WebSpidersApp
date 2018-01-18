package com.Utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class OpenEmulator {

	private static String sdkPath = "/Users/goni/android-sdks/";
	private static String adbPath = sdkPath + "platform-tools" + File.separator + "adb";
	private static String emulatorPath = sdkPath + "tools" + File.separator + "emulator";
	
	

	public static void launchEmulator(String nameOfAVD) {
		System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
		String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(180, TimeUnit.SECONDS);
			System.out.println("Emulator launched successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void closeEmulator() {
	 System.out.println("Killing emulator...");
	 String[] aCommand = new String[] { adbPath, "emu", "kill" };
	 try {
	  Process process = new ProcessBuilder(aCommand).start();
	  process.waitFor(10, TimeUnit.SECONDS);
	  System.out.println("Emulator closed successfully!");
	 } catch (Exception e) {
	  e.printStackTrace();
	 }
	}
	

}
