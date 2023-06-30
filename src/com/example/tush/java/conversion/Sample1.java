package com.example.tush.java.conversion;

public class Sample1 {

	public static void main(String[] args) {
		Character c=Character.valueOf('B');
		System.out.println(fromCharacter(c));
		System.out.println(fromInteger(66));
	}
	
	private static Character fromInteger(Integer i) {
		return Character.valueOf((char)i.intValue());	
	}
	
	private static Integer fromCharacter(Character c) {
		return Integer.valueOf(c.charValue());	
	}
}
