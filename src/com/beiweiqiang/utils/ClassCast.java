package com.beiweiqiang.utils;

public class ClassCast {
  public static Long castDoubleToLong(Object d) {
    return Double.valueOf((Double) d).longValue();
  }
}
