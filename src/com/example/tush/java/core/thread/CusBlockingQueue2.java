package com.example.tush.java.core.thread;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class CusBlockingQueue2 {

	public static void main(String[] args) {
		BlockingQueue q = new CustomQueue(5);
		Producer1 p = new Producer1(q);
		Consumer1 c1 = new Consumer1(q);
		Consumer1 c2 = new Consumer1(q);
		Producer1 p1 = new Producer1(q);
		//new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(p).start();
		new Thread(p1).start();
		System.out.println(q.size());
	}
}

class Producer1 implements Runnable {
	private final BlockingQueue queue;
	int contr = 0;

	Producer1(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		System.out.println("-----in producer run-" + Thread.currentThread().getName());
		try {
			while (contr < 20) {
				contr++;
				System.out.println("@@@@--in producer run-" + contr);
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	String produce() {
		return String.valueOf(contr + 1);
	}
}

class Consumer1 implements Runnable {
	private final BlockingQueue queue;

	int contr = 0;

	Consumer1(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		System.out.println("-----in consumer run-" + Thread.currentThread().getName());
		try {
			while (contr < 20) {
				contr++;
				System.out.println("####--in consumer run-" + contr);
				consume(queue.take());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	void consume(Object x) {
		if (x != null) {
			System.out.println("Queue Value-" + x.toString());
		} else {
			System.out.println("Empty Queue");
		}
	}
}

class CustomQueue implements BlockingQueue<Object> {

	private Queue<Object> queue;
	private int capacity = 10;

	public CustomQueue() {
		queue = new ArrayDeque<Object>(capacity);
	}

	public CustomQueue(int cap) {
		this.capacity = cap;
		queue = new ArrayDeque<Object>(cap);
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		return this.queue.size();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put(Object e) throws InterruptedException {
		synchronized (this) {
			//System.out.println("in put-" + e.toString() + ", size-" + this.queue.size());
			if (this.queue.size() >= capacity) {
				System.out.println("in put, wait()-" + this.queue.size()+", "+ Thread.currentThread().getName());
				wait();
			} else {
				this.queue.add(e);
				notify();
				System.out.println("in put, notify()-" + this.queue.size()+", "+ Thread.currentThread().getName());
			}
		}
	}

	@Override
	public boolean offer(Object e, long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized Object take() throws InterruptedException {
		Object object = null;
		synchronized (this) {
			//System.out.println("in take, size-" + this.queue.size());
			if (this.queue.size() == 0) {
				System.out.println("in take, wait()-" + this.queue.size()+", "+ Thread.currentThread().getName());
				wait();
			} else {
				object = this.queue.poll();
				notify();
				System.out.println("in take, notify()-" + this.queue.size()+", "+ Thread.currentThread().getName());
			}
		}
		return object;
	}

	@Override
	public Object poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super Object> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super Object> c, int maxElements) {
		// TODO Auto-generated method stub
		return 0;
	}

}
