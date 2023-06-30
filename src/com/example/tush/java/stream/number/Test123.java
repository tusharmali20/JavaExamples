package com.example.tush.java.stream.number;

public class Test123 {
	public static void main(String[] args) {
		printPattern(6);
	}

	public static void printPattern(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j>=i; j--) {
				System.out.print(" ");
			}
			for (int k = i-1; k>=-(i-1); k--) {
				System.out.print(i-Math.abs(k));
			}
			System.out.println();
		}
	}
}
