package com.programs.stack;

import java.util.Stack;

public class PostfixToPrefix {
	public static String convertToPrefix(String postfix) {
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < postfix.length(); i++) {
			if(isOperator(postfix.charAt(i))) {
				String operand2 = stack.pop();
				String operand1 = stack.pop();
				stack.push(postfix.charAt(i) + operand1 + operand2);
			}
			else {
				stack.push(postfix.charAt(i) + "");
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/' || value == '^';
	}
}
