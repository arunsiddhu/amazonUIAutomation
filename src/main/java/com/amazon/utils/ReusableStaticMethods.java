package com.amazon.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReusableStaticMethods {
	private static Logger logger = LoggerFactory.getLogger(ReusableStaticMethods.class);

	/*
	 * numcount is total numbers which will select numcount should not be
	 * greater than upper bound
	 */
	public static List<Integer> randomNumber(int lowerbound, int upperbound, int numcount) {
		List<Integer> random = new ArrayList<Integer>();
		final int[] ints = new Random().ints(lowerbound, upperbound + 1).distinct().limit(numcount).toArray();
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
			random.add(ints[i]);
		}
		System.out.println(random);
		return random;
	}

	public static List<Integer> randomNumberDuplicate(int lowerbound, int upperbound, int numcount) {
		List<Integer> random = new ArrayList<Integer>();
		final int[] ints = new Random().ints(lowerbound, upperbound + 1).limit(numcount).toArray();
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
			random.add(ints[i]);
		}
		System.out.println(random);
		return random;
	}

	public static List<String> convertIntegerListToString(List<Integer> list) {
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < 10) {
				temp.add("0" + list.get(i));
			} else {
				temp.add(String.valueOf(list.get(i)));
			}

		}
		return temp;

	}

	public static String IntegerListToString(List<Integer> list, String string) {
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			str = str + list.get(i);
		}
		return string + str;

	}

	public static String StringListToString(List<String> list) {
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			str = str + list.get(i) + ",";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public static String covertStringToTwoDecimalNum(String input) {
		float ftnum = Float.parseFloat(input);
		return String.format("%.2f", ftnum);
	}

	public static List<String> convertIntegerListToStringList(List<Integer> list) {
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			temp.add(String.valueOf(list.get(i)));
		}
		return temp;
	}

	public static void writeServerFalureCountToFile(String count) {
		Path source = Paths.get("serverstatus.txt");
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(source, charset, StandardOpenOption.CREATE,
				StandardOpenOption.WRITE)) {
			writer.append("serverdowncount=");
			writer.write(count);
			writer.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static String readServerFalureCountFromFile() {
		Path source = Paths.get("serverstatus.txt");
		Charset charset = Charset.forName("US-ASCII");
		String line = null;
		try (BufferedReader reader = Files.newBufferedReader(source, charset)) {
			line = reader.readLine();
			return line.split("=")[1];
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void createServerStatusFile() throws IOException {
		Path source = Paths.get("serverstatus.txt");
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(source, charset, StandardOpenOption.CREATE)) {
			BufferedReader reader = Files.newBufferedReader(source, charset);
			if (reader.readLine() == null) {
				writer.write("serverdowncount=0");

			} else {
				System.out.println("File Exist");
			}
			writer.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
