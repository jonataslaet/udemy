package com.github.jonataslaet.controllers;

import com.github.jonataslaet.exceptions.UnsupportedMathOperationException;
import com.github.jonataslaet.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

  private final OperationService operationService;

  @Autowired
  public MathController(OperationService operationService) {
    this.operationService = operationService;
  }

  @RequestMapping("/sum/{numberOne}/{numberTwo}")
  public Double getSum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {
    return operationService.getSum(numberOne, numberTwo);
  }

  @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
  public Double getSubtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {
    return operationService.getSubtraction(numberOne, numberTwo);
  }

  @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
  public Double getMultiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {
    return operationService.getMultiplication(numberOne, numberTwo);
  }

  @RequestMapping("/division/{numberOne}/{numberTwo}")
  public Double getDivision(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {
    return operationService.getDivision(numberOne, numberTwo);
  }

  @RequestMapping("/mean/{numberOne}/{numberTwo}")
  public Double getMean(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {
    return operationService.getMean(numberOne, numberTwo);
  }

  @RequestMapping("/square-root/{number}")
  public Double getSquareRoot(@PathVariable(value = "number") String number)
      throws UnsupportedMathOperationException {
    return operationService.getSquareRoot(number);
  }
}
