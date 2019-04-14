package com.programs.stack;

import java.util.Stack;

public class PostfixToInfix {
	
	public static String convertToInfix(String postfix) {
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < postfix.length(); i++) {
			if(isOperator(postfix.charAt(i))) {
				String operand2 = stack.pop();
				String operand1 = stack.pop();
				stack.push("(" + operand1 + postfix.charAt(i) + operand2 + ")");
			}
			else {
				stack.push(postfix.charAt(i) + "");
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
	}

}
