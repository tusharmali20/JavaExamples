package com.example.tush.java.core.poly;

public class B extends A {
	void mt1() {
		System.out.println("mt1");
	}

	void mt1(Integer i, Long l) {
		System.out.println("mt2");
	}

	void mt1(int i, long l) {
		System.out.println("mt3");
	}

	void mt1(Integer i, long l) {
		System.out.println("mt4");
	}

	void mt1(int i, Long l) {
		System.out.println("mt5");
	}

	void mt1(long l, int i) {
		System.out.println("mt6");
	}

	void mt1(Long l, Integer i) {
		System.out.println("mt7");
	}

	void mt1(Integer i, Integer j) {
		System.out.println("mt8");
	}

	void mt1(int i, int j) {
		System.out.println("mt9");
	}

	void mt1(int i) {
		System.out.println("mt10");
	}

	void mt1(long l) {
		System.out.println("mt11");
	}

	void mt1(Integer i) {
		System.out.println("mt12");
	}

	void mt1(Long l) {
		System.out.println("mt13");
	}
	
	void mt1(long l, Integer i) {
		System.out.println("mt14");
	}
}
