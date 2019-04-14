package com.programs.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Priyanka_Sarkar
 *
 */

public class InfixToPrefix {
	
	private static final Map<Character, Integer> precedence;

	/*
	 * Initializes the static final field "precedence" according to the precedence
	 * of the different operators.
	 */

	static {
		precedence = new HashMap<>();
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 3);
		precedence.put('^', 4);
	}
	
	private InfixToPrefix() {
		// private constructor to ensure non-instantiability. (Utility class)
	}
	
	public static String convertToPrefix(String infix) {
		infix = reverse(infix);
		infix = convertToPostfix(infix);
		return reverse(infix);
	}

	private static String convertToPostfix(String infix) {
		
		StringBuilder postfix = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < infix.length(); i++) {
			
			char current = infix.charAt(i);
			
			/*
			 * If the scanned character is a '(', push to stack.
			 */
			
			if (current == '(') {
				stack.push(current);
			}

			/*
			 * If the scanned character is ')' pop and append to result string until '(' is
			 * found in the stack. Then finally pop '(' also from the stack.
			 */

			else if(current == ')') {
				while(stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.pop();
			}

			/*
			 * If the scanned character is an operand, append to result string.
			 */
			
			else if(!isOperator(current)) {
				postfix.append(current);
			}
			
			/*
			 * If the scanned character is an operator, push to the stack only if any of the
			 * following conditions hold true :
			 *
			 * 1. If the stack is empty.
			 * 2. If the character on top of the stack if a '('
			 * character.
			 * 3. If the scanned character is of higher precedence than the
			 * character on top of the stack.
			 * 
			 * Pop from the stack and append to the result string otherwise.
			 * 
			 */
			
			else {
				while(!stack.isEmpty() && stack.peek() != '(' 
						&& precedence.get(current) <= precedence.get(stack.peek())) {
					postfix.append(stack.pop());
				}
				stack.push(current);
			}
 		}
		while(!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		return postfix.toString();
	}

	private static String reverse(String expression) {
		StringBuilder reversedExpression = new StringBuilder();
		for(int i = expression.length() - 1; i >= 0; i--) {
			char ch = expression.charAt(i);
			if(ch == '(') {
				ch = ')';
			}
			else if(ch == ')') {
				ch = '(';
			}
			reversedExpression.append(ch);
		}
		return reversedExpression.toString();
	}

	private static boolean isOperator(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/' || value == '^';
	}
}
