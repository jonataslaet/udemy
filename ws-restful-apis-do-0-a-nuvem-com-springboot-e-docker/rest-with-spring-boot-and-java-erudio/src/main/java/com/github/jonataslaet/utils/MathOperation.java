package com.github.jonataslaet.utils;

import static com.github.jonataslaet.utils.ConversionNumber.convertToDouble;

public class MathOperation {
  public static Double sum(String numberOne, String numberTwo) {
    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  public static Double division(String numberOne, String numberTwo) {
    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  public static Double subtraction(String numberOne, String numberTwo) {
    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  public static Double squareRoot(String number) {
    return Math.sqrt(convertToDouble(number));
  }

  public static Double multiply(String numberOne, String numberTwo) {
    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  public static Double mean(String numberOne, String numberTwo) {
    return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2.0;
  }
}
