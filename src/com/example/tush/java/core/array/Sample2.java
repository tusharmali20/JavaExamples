package com.example.tush.java.core.array;

public class Sample2 {
	public static void main(String[] args) {
		// { {“A”, 3, 5}, {“Z”, 7, 1}, {“Z”, 4, 4}, {“A”, 2, 6} }
		int maxX = 8, maxY = 7;
		printBlocks(maxX, maxY);
	}

	private static void printBlocks(int maxX, int maxY) {
		String[][] xArr=new String[maxX][maxY];
		xArr[3][5]="A";
		xArr[7][1]="Z";
		xArr[4][4]="Z";
		xArr[2][6]="A";
		for (int i = 1; i < maxX; i++) {
			printDesign(maxY);
			System.out.println();
			for (int j = maxY-1; j >= 0; j--) {
				if (j == maxY-1) {
					System.out.print("|");
				}
				if(xArr[i][j]!=null){
					System.out.print(" " + xArr[i][j] + " |");
				} else {
					System.out.print("   |");
				}
				//System.out.print(" " + j + " |");
			}
			System.out.print("  " + (maxX-i) + " ");
			System.out.println();
		}
		printDesign(maxY);
		System.out.println();
		for (int j = 0; j < maxY; j++) {
			System.out.print("  " + (j + 0) + " ");
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