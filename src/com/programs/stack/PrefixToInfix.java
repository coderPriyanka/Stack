package com.programs.stack;

import java.util.Stack;

public class PrefixToInfix {
  
  public static String convertToInfix(String prefix) {
    Stack<String> stack = new Stack<>();
    for(int i = prefix.length() - 1; i >= 0; i--) {
      char scannedCharacter = prefix.charAt(i);
      if(isOperator(scannedCharacter)) {
        String operand1 = stack.pop();
        String operand2 = stack.pop();
        stack.push("(" + operand1 + scannedCharacter + operand2 + ")");
      }
      else {
        stack.push(scannedCharacter + "");
      }
    }
    return stack.pop().toString();
  }
  private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  }
}
