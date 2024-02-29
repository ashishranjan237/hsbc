package com.hsbc;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @author ashish
 *
 */
public class ReverseFileContentTest {

	@Test
	public void testReverseFile_contentIsNull() throws IOException {
		String input = "";
		String expectedOutput = "";
		String inputFile = "testInput.txt";
		String outputFile = "testOutput.txt";
		createTestFile(inputFile, input);
		ReverseFileContent reverseFileContent = new ReverseFileContent();
		reverseFileContent.reverseFile(inputFile, outputFile);
		String actualOutput = readFromFile(outputFile);

		assertEquals(expectedOutput, actualOutput);
		deleteTestFile(inputFile);
		deleteTestFile(outputFile);

	}

	@Test
	public void testReverseFile() throws IOException {
		String input = "ABC";
		String expectedOutput = "CBA";
		String inputFile = "testInput.txt";
		String outputFile = "testOutput.txt";
		createTestFile(inputFile, input);
		ReverseFileContent reverseFileContent = new ReverseFileContent();
		reverseFileContent.reverseFile(inputFile, outputFile);
		String actualOutput = readFromFile(outputFile);
		assertEquals(expectedOutput, actualOutput);
		deleteTestFile(inputFile);
		deleteTestFile(outputFile);
	}

	private void createTestFile(String fileName, String content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(content);
		}
	}

	private String readFromFile(String fileName) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		}
		return content.toString();
	}

	private void deleteTestFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
	}

}
