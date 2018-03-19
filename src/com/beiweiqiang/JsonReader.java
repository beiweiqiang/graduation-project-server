package com.beiweiqiang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;


public class JsonReader {
  private static final Logger myLogger = Logger.getLogger("JsonReader");
  public static Map receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException, JsonSyntaxException {

    // 读取请求内容
    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
    String line = null;

    StringBuilder sb = new StringBuilder();
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    myLogger.info(sb.toString());
//    JsonParser jsonParser = new JsonParser();
//    JsonObject jsonObject = jsonParser.parse(sb.toString()).getAsJsonObject();
    Map<String, Object> retMap = new Gson().fromJson(
            sb.toString(), new TypeToken<HashMap<String, Object>>() {}.getType()
    );
    return retMap;
//    JsonElement jsonElement =
    //将json字符串转换为json对象
//    JSONObject json = JSONObject.fromObject(sb.toString());
//    JSONObject json = new JSONObject(sb.toString());
//    return json;
  }
}
