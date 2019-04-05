package com.programs.stack;

import java.util.Stack;

/**
 * 
 * @author Priyanka_Sarkar
 *
 */

public class BalancedParenthesis {
	
	public static boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		for(int index = 0; index < input.length(); index++) {
			if(isOpeningParenthesis(input.charAt(index))) {
				stack.push(input.charAt(index));
				continue;
			}
			if(stack.isEmpty() || !isMatchingParenthesis(input.charAt(index), stack.peek())) {
				return false;
			}
			stack.pop();
		}
		return stack.isEmpty();
	}

	private static boolean isMatchingParenthesis(char ch1, Character ch2) {
		return (ch1 == ')' && ch2 == '(') || (ch1 == '}' && ch2 == '{') || (ch1 == ']' && ch2 == '[') || (ch1 == '>' && ch2 == '<');
	}

	private static boolean isOpeningParenthesis(char ch) {
		return ch == '(' || ch == '{' || ch == '[' || ch == '<';
	}
}
