package com.beiweiqiang.utils;

import java.util.Map;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.commons.logging.LogFactory;

public class BeanUtils {
  private static final Logger myLogger = Logger.getLogger(BeanUtils.class.getSimpleName());

  public static <T> T toBean(Map map, Class<T> tClass) {
    try {
      myLogger.info(map.toString());
      Gson gson = new Gson();
      JsonElement jsonElement = gson.toJsonTree(map);
      T bean = gson.fromJson(jsonElement, tClass);
      return bean;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
