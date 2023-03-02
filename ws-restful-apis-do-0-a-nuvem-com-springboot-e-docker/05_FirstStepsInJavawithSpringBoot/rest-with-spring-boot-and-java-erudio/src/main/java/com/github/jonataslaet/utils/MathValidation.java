package com.github.jonataslaet.utils;

import com.github.jonataslaet.exceptions.UnsupportedMathOperationException;
import java.util.Objects;

public class MathValidation {

  public static boolean isNumeric(String strNumber) {
    if (Objects.isNull(strNumber)) return false;
    String number = strNumber.replaceAll(",",".");
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }

  public static void validateNumeric(String number) {
    if (!isNumeric(number) || !isNumeric(number)) {
      throw new UnsupportedMathOperationException("Please, set a numeric value!");
    }
  }
}
