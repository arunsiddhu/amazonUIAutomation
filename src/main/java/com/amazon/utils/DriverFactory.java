package com.amazon.utils;

import java.io.IOException;

public class DriverFactory {
	static Process process;
	static ProcessBuilder builder;

	/* This method Is responsible for starting appium server. */
	public static void appiumStart() throws IOException, InterruptedException {
		String[] command = { "cmd.exe", "/C",
				"Start appium -a 127.0.0.1 -p " + ConfigManager.getProperty("AppiumPort") };

		ProcessBuilder pb;
		if (process == null) {
			pb = new ProcessBuilder(command);
			process = pb.start();
			Thread.sleep(20000);
		}
		if (process != null) {
			System.out.println("SERVER STARTED");
		}
	}

	/* This method Is responsible for stopping appium server. */
	public static void appiumStop() {
		builder = new ProcessBuilder("cmd.exe", "/c", "taskkill /f /im " + "node.exe");
		builder.redirectErrorStream(true);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TASK KILLED");
	}
}