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

  /*
   * Initializes the static final field "precedence" according to the precedence
   * of the different operators.
   */

  static {
    precedence.put('+', 1);
    precedence.put('-', 1);
    precedence.put('*', 2);
    precedence.put('/', 3);
    precedence.put('^', 4);
  }

  private InfixToPostfix() {
    // private constructor to ensure non-instantiability. (Utility class)
  }

  public static String convertToPostfix(String infix) {

    StringBuilder postfix = new StringBuilder();

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < infix.length(); i++) {

      char scannedCharacter = infix.charAt(i);

      /*
       * If the scanned character is a '(', push to stack.
       */

      if (scannedCharacter == '(') {
        stack.push(scannedCharacter);
      }

      /*
       * If the scanned character is ')' pop and append to result string until '(' is
       * found in the stack. Then finally pop '(' also from the stack.
       */

      else if (scannedCharacter == ')') {
        while (stack.peek() != '(') {
          postfix.append(stack.pop());
        }
        stack.pop();
      }

      /*
       * If the scanned character is an operand, append to result string.
       */

      else if (!isOperator(scannedCharacter)) {
        postfix.append(scannedCharacter);
      }

      /*
       * If the scanned character is an operator, push to the stack only if any of the
       * following conditions hold true :
       *
       * 1. If the stack is empty.
       * 2. If the character on top of the stack if a '('
       *    character.
       * 3. If the scanned character is of higher precedence than the
       * character on top of the stack.
       * 
       * Pop from the stack and append to the result string otherwise.
       * 
       */

      else {
        while (!stack.isEmpty() && stack.peek() != '('
            && precedence.get(scannedCharacter) <= precedence.get(stack.peek())) {
          postfix.append(stack.pop());
        }
        stack.push(scannedCharacter);
      }

    }

    while (!stack.isEmpty()) {
      postfix.append(stack.pop());
    }

    return postfix.toString();

  }

  private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  }

}
