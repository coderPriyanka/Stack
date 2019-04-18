package com.programs.stack;

import java.util.Stack;

public class InfixExpressionEvaluation {
  
  public static double evaluate(String infix) {
    System.out.println(infix);
    Stack<Double> value = new Stack<>();
    Stack<Character> operator = new Stack<>();
    char[] tokens = infix.toCharArray();
    for(int i = 0; i < tokens.length; i++) {
      //System.out.println(tokens[i]);
      if(tokens[i] == ' ') {
        continue;
      }
      if(tokens[i] == '(') {
        operator.push(tokens[i]);
      }
      else if(tokens[i] == ')') {
        while(operator.peek() != '(') {
          value.push(performOperation(value.pop(), operator.pop(), value.pop()));
        }
        operator.pop();
      }
      else if(isOperator(tokens[i])) {
        while(!operator.isEmpty() && operator.peek() != '(' && !hasHigherPrecedence(tokens[i], operator.peek())) {
          value.push(performOperation(value.pop(), operator.pop(), value.pop()));
        }
        operator.push(tokens[i]);
      }
      else {
        StringBuilder number = new StringBuilder();
        while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
          number.append(tokens[i]);
          //System.out.println("Value = " + tokens[i]);
          i++;
        }
        value.push(Double.parseDouble(number.toString()));
      }
    }
    while(!operator.isEmpty()) {
      value.push(performOperation(value.pop(), operator.pop(), value.pop()));
    }
    return value.pop();
  }

  private static double performOperation(double value2, Character operator, double value1) {
    double result = 0;
    if(operator == '+') {
      return value1 + value2;
    }
    if(operator == '-') {
      return value1 - value2;
    }
    if(operator == '*') {
      return value1 * value2;
    }
    if(operator == '/') {
      return value1 / value2;
    }
    return result;
  }
  
  private static boolean hasHigherPrecedence(char op1, char op2) {
    if((op1 == '+' && op2 == '-') || (op1 == '*' && op2 == '/')) {
      return false;
    }
    if((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) {
      return false;
    }
    return true;
  }

  private static boolean isOperator(char value) {
    return value == '+' || value == '-' || value == '*' || value == '/';
  }

}
