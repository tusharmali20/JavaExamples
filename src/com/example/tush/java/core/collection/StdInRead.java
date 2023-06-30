package com.example.tush.java.core.collection;

import java.util.Scanner;

public class StdInRead {
	public static void main(String[] args) {
		read();
	}

	private static void read() {
		int firstNum, secondNum, result;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a first number:");
		firstNum = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter a second number:");
		secondNum = scanner.nextInt();
		result = firstNum * secondNum;
		System.out.println("The Result is: " + result);
		System.out.println("Enter a Name:");
		String name = scanner.next();
		System.out.println("Hi "+name);
	}
}
