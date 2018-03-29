package com.beiweiqiang.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


public class JsonReader {
  private static final Logger myLogger = Logger.getLogger(JsonReader.class.getSimpleName());
  public static Map receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException, JsonSyntaxException {

    // 读取请求内容
    BufferedReader br = new BufferedReader(
            new InputStreamReader(
                    request.getInputStream(),
                    StandardCharsets.UTF_8
            )
    );
    String line = null;
    StringBuilder sb = new StringBuilder();
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    myLogger.info(sb.toString());
    Map<String, Object> retMap = new Gson().fromJson(
            sb.toString(), new TypeToken<HashMap<String, Object>>() {}.getType()
    );
    return retMap;
  }
}

