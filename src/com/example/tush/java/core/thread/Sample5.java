package com.example.tush.java.core.thread;

public class Sample5 {
	String s = "abcdefghijkl";
	static int len=8;
	int counter = 0;

	public void printOdd() throws InterruptedException {
		while (counter < s.length()-1) {
			synchronized (this) {
				if (counter % 2 != 0) {
					System.out.println("waiting odd counter-"+counter);
					wait();
				}

				System.out.println("Char-" + s.charAt(counter));
				counter = counter + 1;
				notify();
			}
		}
	}

	public void printEven() throws InterruptedException {
		while (counter < s.length()-1) {
			synchronized (this) {
				if (counter % 2 == 0) {
					System.out.println("waiting Even counter-"+counter);
					wait();
				}

				System.out.println("Char-" + s.charAt(counter));
				counter = counter + 1;
				notify();
			}
		}
	}

	public static void main(String[] args) {
		Sample5 sample5 = new Sample5();
		Runnable r1 = () -> {
			try {
				sample5.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable r2 = () -> {
			try {
				sample5.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		th1.start();
		th2.start();
	}
}
