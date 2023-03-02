package com.github.jonataslaet.services;

import static com.github.jonataslaet.utils.MathOperation.division;
import static com.github.jonataslaet.utils.MathOperation.mean;
import static com.github.jonataslaet.utils.MathOperation.multiply;
import static com.github.jonataslaet.utils.MathOperation.squareRoot;
import static com.github.jonataslaet.utils.MathOperation.subtraction;
import static com.github.jonataslaet.utils.MathOperation.sum;
import static com.github.jonataslaet.utils.MathValidation.validateNumeric;

import org.springframework.stereotype.Service;

@Service
public class OperationService {
  public Double getSum(String numberOne, String numberTwo) {
    validateNumeric(numberOne);
    validateNumeric(numberTwo);
    return sum(numberOne, numberTwo);
  }

  public Double getSubtraction(String numberOne, String numberTwo) {
    validateNumeric(numberOne);
    validateNumeric(numberTwo);
    return subtraction(numberOne, numberTwo);
  }

  public Double getDivision(String numberOne, String numberTwo) {
    validateNumeric(numberOne);
    validateNumeric(numberTwo);
    return division(numberOne, numberTwo);
  }

  public Double getMultiplication(String numberOne, String numberTwo) {
    validateNumeric(numberOne);
    validateNumeric(numberTwo);
    return multiply(numberOne, numberTwo);
  }

  public Double getMean(String numberOne, String numberTwo) {
    validateNumeric(numberOne);
    validateNumeric(numberTwo);
    return mean(numberOne, numberTwo);
  }

  public Double getSquareRoot(String number) {
    validateNumeric(number);
    return squareRoot(number);
  }

}
