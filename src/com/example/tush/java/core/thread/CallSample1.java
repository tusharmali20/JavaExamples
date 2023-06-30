package com.example.tush.java.core.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallSample1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// Create random number generator
		Random generator = new Random();

		Integer randomNumber = generator.nextInt(5);

		// To simulate a heavy computation,
		// we delay the thread for some random time
		Thread.sleep(randomNumber * 1000);
		System.out.println("Random-"+randomNumber);
		return randomNumber;
	}

	public static void main(String[] args) {
		FutureTask[] futureTasks = new FutureTask[5];
		for (int i = 0; i < 5; i++) {
			Callable callable = new CallSample1();

			// Create the FutureTask with Callable
			futureTasks[i] = new FutureTask(callable);

			// As it implements Runnable, create Thread
			// with FutureTask
			Thread t = new Thread(futureTasks[i]);
			t.start();
		}
		for (int i = 0; i < 5; i++)
	    {
	      // As it implements Future, we can call get()
	      try {
			System.out.println("Result-"+futureTasks[i].get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	      // This method blocks till the result is obtained
	      // The get method can throw checked exceptions
	      // like when it is interrupted. This is the reason
	      // for adding the throws clause to main
	    }

	}

}
