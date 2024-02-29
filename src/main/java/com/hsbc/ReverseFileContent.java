package com.hsbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ashish
 *
 */
public class ReverseFileContent {

	private static final String BLANK = "";
	private static final String NEW_LINE = "\n";

	/**
	 * @param inputFile
	 * @param outputFile
	 * @throws IOException
	 */
	public void reverseFile(String inputFile, String outputFile) throws IOException {
		String content = BLANK;
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content = content.concat(line);
				content = content.concat(NEW_LINE);
			}
		}
		String reversedContent = reverseString(content);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			writer.write(reversedContent);
		}
	}

	/**
	 * @param content
	 * @return
	 */
	private String reverseString(String content) {

		if (content == null || content.isEmpty()) {
			return content;
		}

		char[] charArray = content.toCharArray();
		int left = 0;
		int right = charArray.length - 1;

		while (left < right) {
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;
			left++;
			right--;
		}

		return new String(charArray);
	}
}
