package com.beiweiqiang.service;

import com.beiweiqiang.model.UserQuestion;

import com.beiweiqiang.utils.ClassCast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

public class ChattingService {
  private static String url = "http://openapi.tuling123.com/openapi/api/v2";
  private static final Logger myLogger = Logger.getLogger(ChattingService.class.getSimpleName());

  public static String question(UserQuestion userQuestion) {
    String text = userQuestion.getText();
    String userId = userQuestion.getUserId() + "";
    String jsonstr = String.format(("{\n" +
            "\t\"reqType\":0,\n" +
            "    \"perception\": {\n" +
            "        \"inputText\": {\n" +
            "            \"text\": \"%s\"\n" +
            "        },\n" +
            "        \"selfInfo\": {\n" +
            "            \"location\": {\n" +
            "                \"city\": \"广州\",\n" +
            "                \"province\": \"\",\n" +
            "                \"street\": \"\"\n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
            "    \"userInfo\": {\n" +
            "        \"apiKey\": \"369ce9acf8a6439389d77fc1e755e288\",\n" +
            "        \"userId\": \"%s\"\n" +
            "    }\n" +
            "}"), text, userId);
    myLogger.info(jsonstr);
    JSONObject jsonObject = new JSONObject(jsonstr);
    return post(jsonObject);
  }

  private static String post(JSONObject jsonObject) {
    HttpPost post = new HttpPost(url);
    HttpClient httpClient = HttpClientBuilder.create().build();

    HttpResponse httpResponse;
    try {
      StringEntity params = new StringEntity(jsonObject.toString());
      post.addHeader("content-type", "application/json");
      post.addHeader("Accept","application/json");
      post.setEntity(params);
      httpResponse = httpClient.execute(post);

      HttpEntity entity = httpResponse.getEntity();
      String responseString = EntityUtils.toString(entity, "UTF-8");
      Map map = ClassCast.stringToMap(responseString);
      myLogger.info(responseString);
      ArrayList results = (ArrayList) map.get("results");
      myLogger.info(results.toString());
      Map result = (Map) results.get(0);
      myLogger.info(result.toString());
      String text = (String) ((Map) result.get("values")).get("text");
      myLogger.info(text);
      return text;
    } catch (UnsupportedEncodingException e) {

    } catch (IOException e) {

    } finally {
      httpClient.getConnectionManager().shutdown();
    }
    return "";
  }
}
