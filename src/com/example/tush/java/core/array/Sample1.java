package com.example.tush.java.core.array;

public class Sample1 {
	public static void main(String[] args) {
		int maxX = 7, maxY = 6;
		printBlocks(maxX, maxY);
	}

	private static void printBlocks(int maxX, int maxY) {
		for (int i = maxX - 1; i >= 0; i--) {
			printDesign(maxY);
			System.out.println();
			for (int j = 0; j < maxY; j++) {
				if (j == 0) {
					System.out.print("|");
				}
				System.out.print(" " + j + " |");
			}
			System.out.print("  " + (i + 1) + " ");
			System.out.println();
		}
		printDesign(maxY);
		System.out.println();
		for (int j = 0; j < maxY; j++) {
			System.out.print("  " + (j + 1) + " ");
		}
	}
	
	private static void printDesign(int maxY) {
		for (int j = 0; j < maxY; j++) {
			if (j == 0) {
				System.out.print("+");
			}
			System.out.print("---+");
		}
	}
}

class Battleship {

	String teamName;

	int SectorX;

	int SectorY;

}