package com.beiweiqiang.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class ClassCast {
  public static Long castDoubleToLong(Object d) {
    return Double.valueOf((Double) d).longValue();
  }

  public static Map stringToMap(String s) {
     Map<String, Object> retMap = new Gson().fromJson(
            s, new TypeToken<HashMap<String, Object>>() {}.getType()
    );
    return retMap;
  }
}
