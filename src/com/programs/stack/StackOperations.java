package com.programs.stack;

import java.util.Stack;

public class StackOperations<T> {

	public void reverseStackUsingRecursion(Stack<T> stack) {
		if(stack.isEmpty()) {
			return;
		}
		T element = stack.pop();
		reverseStackUsingRecursion(stack);
		insertAtBottom(element, stack);
	}

	private void insertAtBottom(T element, Stack<T> stack) {
		if(stack.isEmpty()) {
			stack.push(element);
			return;
		}
		T item = stack.pop();
		insertAtBottom(element, stack);
		stack.push(item);
	}
	
	public void sortStackUsingRecursion(Stack<T> stack) {
		if(stack.isEmpty()) {
			return;
		}
		T element = stack.pop();
		sortStackUsingRecursion(stack);
		insertInSortedOrder(element, stack);
	}

	private void insertInSortedOrder(T element, Stack<T> stack) {
		if(stack.isEmpty() || stack.peek().compare(element) > 0) {
			stack.push(element);
		}
	}
	
}
