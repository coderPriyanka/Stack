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

public class StackUsingQueue<T> {
	
	private Queue<T> queue;
	private int size;
	
	public StackUsingQueue() {
		queue = new LinkedList<>();
		this.size = 0;
	}
	
	public void push(T data) {
		queue.add(data);
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty.");
		}
		for(int i = 1; i < size; i++) {
			queue.add(queue.poll());
		}
		size--;
		return queue.poll();
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty.");
		}
		for(int i = 1; i < size; i++) {
			queue.add(queue.poll());
		}
		queue.add(queue.peek());
		return queue.poll();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
