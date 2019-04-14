package com.programs.stack;

import java.util.Stack;

public class PrefixToInfix {
  
	public static String convertToInfix(String prefix) {
		Stack<String> stack = new Stack<>();
		for(int i = prefix.length() - 1; i >= 0; i--) {
			char scannerCharacter = prefix.charAt(i);
			if(isOperator(scannerCharacter)) {
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				stack.push("(" + operand1 + scannerCharacter + operand2 + ")"); 
			}
			else {
				stack.push(scannerCharacter + "");
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/' || value == '^';
	}
	
}
