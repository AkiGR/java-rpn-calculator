# Java RPN Calculator

This repository contains a Reverse Polish Notation (RPN) calculator implemented in Java.

## Overview

The RPN calculator provided in this project is capable of converting mathematical expressions from infix notation to Reverse Polish Notation (RPN), and then evaluating them. Reverse Polish Notation is a mathematical notation in which every operator follows all of its operands, making it particularly suitable for parsing and evaluating expressions.

## Features

- Convert infix notation expressions to Reverse Polish Notation.
- Evaluate expressions in Reverse Polish Notation.
- Support for basic arithmetic operations: addition, subtraction, multiplication, and division.
- Error handling for division by zero and invalid expressions.

## Usage

```java
String expression = "3 + 4 * 5";
double result = ReversePolishNotationCalculator.evaluate(expression);
System.out.println("Result: " + result);
```

## Contributing

Contributions to this project are welcome! Feel free to open an issue for any bugs or feature requests, or submit a pull request with improvements.
