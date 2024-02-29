package com.hsbc;

public class StringReverser {
    public static String createReversedString(int length) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = length; i >= 1; i--) {
            reversedString.append((char) (i % 26 + 'a')); // Generating lowercase letters in reverse order
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        int length = 100;
        String reversedString = createReversedString(length);
        System.out.println("Reversed String (100 letters):");
        System.out.println(reversedString);
    }
}

