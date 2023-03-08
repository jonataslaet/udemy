package com.github.jonataslaet.utils;

import static com.github.jonataslaet.utils.MathValidation.isNumeric;

import java.util.Objects;

public class ConversionNumber {

  public static Double convertToDouble(String strNumber) {
    if (Objects.isNull(strNumber)) return 0D;
    String number = strNumber.replaceAll(",",".");
    if (isNumeric(number)) return Double.parseDouble(number);
    return 0D;
  }

}
