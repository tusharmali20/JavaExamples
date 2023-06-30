package com.example.tush.java.core.poly;

public interface E {
	void display();
	
	default void play() {
		System.out.println("E play");
	}
}
