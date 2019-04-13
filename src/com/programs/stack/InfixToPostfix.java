package com.programs.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Priyanka_Sarkar
 *
 */

public class InfixToPostfix {

  private static final Map<Character, Integer> precedence = new HashMap<>();
  
  static {
    precedence.put('+', 1);
    precedence.put('-', 1);
    precedence.put('*', 2);
    precedence.put('/', 3);
    precedence.put('^', 4);
  }
  
  private InfixToPostfix() {
    
  }
  
  public static String convertToPostfix(String infix) {
    
    StringBuilder postfix = new StringBuilder();
    
    Stack<Character> stack = new Stack<>();
    
    for(int i = 0; i < infix.length(); i++) {
      
      char scannedCharacter = infix.charAt(i);
      
      if(scannedCharacter == '(') {
        stack.push(scannedCharacter);
      }
      
      else if(scannedCharacter == ')') {
        while(stack.peek() != '(') {
          postfix.append(stack.pop());
        }
        stack.pop();
      }
      
      else if(!isOperator(scannedCharacter)) {
        postfix.append(scannedCharacter);
      }
      
      else {
        while(!stack.isEmpty() && stack.peek() != '(' && precedence.get(scannedCharacter) <= precedence.get(stack.peek())) {
          postfix.append(stack.pop());
        }
        stack.push(scannedCharacter);
      }
      
    }
    
    while(!stack.isEmpty()) {
      postfix.append(stack.pop());
    }
    
    return postfix.toString();
    
  }

  private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  }
  
}
