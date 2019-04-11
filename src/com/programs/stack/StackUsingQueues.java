package com.programs.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 
 * @author Priyanka_Sarkar
 *
 * @param <T>
 */

public class StackUsingQueues<T> {
	
	private Queue<T> q1;
	private Queue<T> q2;
	private int size;
	
	public StackUsingQueues() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		this.size = 0;
	}
	
	public void push(T data) {
		q1.add(data);
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty.");
		}
		for(int i = 1; i < size; i++) {
			q2.add(q1.poll());
		}
		Queue<T> q = q1;
		q1 = q2;
		q2 = q;
		size--;
		return q2.poll();
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty.");
		}
		for(int i = 1; i < size; i++) {
			q2.add(q1.poll());
		}
		Queue<T> q = q1;
		q1 = q2;
		q2 = q;
		return q2.peek();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
