package com.programs.stack;

import java.util.Stack;

public class PrefixToPostfix {
	public static String convertToPostfix(String prefix) {
		Stack<String> stack = new Stack<>();
		for(int i = prefix.length() - 1; i>= 0; i--) {
			if(isOperator(prefix.charAt(i))) {
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				stack.push(operand1 + operand2 + prefix.charAt(i));
			}
			else {
				stack.push(prefix.charAt(i) + "");
			}
		}
		return stack.pop();
	}
	
	private static boolean isOperator(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/' || value == '^';
	}

}
