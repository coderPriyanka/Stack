package com.programs.stack;

import java.util.Stack;

/**
 * 
 * @author Priyanka_Sarkar
 *
 * @param <T>
 */

public class QueueUsingStack<T> {
	
	private Stack<T> stack1;
	private Stack<T> stack2;
	private int size;
	
	public QueueUsingStack () {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
		this.size = 0;
	}
	
	public void enqueue(T data) {
		stack1.push(data);
		size++;
	}
	
	public T dequeue() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		size--;
		return stack2.pop();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
}
