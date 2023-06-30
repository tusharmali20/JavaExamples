package com.example.tush.java.core.exception;

import java.io.IOException;

public class FinalTest {

	public static void main(String[] args) {
		System.out.println(testFinal());
	}
	
	private static int testFinal() {
		try {
			//return 1;
			throw new IOException("IO Error");
		} catch (Exception e) {
			System.out.println(e);
			return 2;
			//throw e;
		} finally {
			System.out.println("Finally Block");
			//return 0;
		}
	}
}
