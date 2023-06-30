package com.example.tush.java.core.poly;

public class Test implements D,E{
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.m1(null);//2
		//The method mt1(int, long) is ambiguous for the type B
		//b.mt1(1, 2);
		
		//The method mt1(long, int) in the type B is not applicable for the arguments (long, long)
		//b.mt1(1L, 2L);
		
		b.mt1(1, 2L);//mt3
		b.mt1(1L, 2);//mt6
		b.mt1(1);//mt10
		b.mt1(2l);//mt11
		b.mt1(1,2);//mt9
		
		C c =new C();
		c.add(2, 3);
		
		D d=new Test();
		d.play();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		D.super.play();
	}
}
