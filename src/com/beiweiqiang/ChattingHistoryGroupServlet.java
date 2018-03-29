package com.beiweiqiang;

import com.beiweiqiang.model.ChattingHistory;
import com.beiweiqiang.model.Response;
import com.beiweiqiang.service.ChattingHistoryService;
import com.beiweiqiang.utils.BeanUtils;
import com.beiweiqiang.utils.JsonReader;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(
        name = "ChattingHistoryGroupServlet",
        urlPatterns = { "/chattingHistory/group" }
)
public class ChattingHistoryGroupServlet extends HttpServlet {
  private static final Logger myLogger = Logger.getLogger(ChattingHistoryGroupServlet.class.getSimpleName());
  private static final long serialVersionUID = 5L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置字符编码为UTF-8, 这样支持汉字显示
    response.setCharacterEncoding("UTF-8");
//    request.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    /** 设置响应头允许ajax跨域访问 **/
    response.setHeader("Access-Control-Allow-Origin", "*");
    /* 星号表示所有的异域请求都可以接受， */
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");

    Map map = JsonReader.receivePost(request);
    ChattingHistory chattingHistory = BeanUtils.toBean(map, ChattingHistory.class);


    try {
      ArrayList<String> arrayList = ChattingHistoryService.getAllGroupName(chattingHistory);
      Response response1 = new Response(200, "success", arrayList);
      String json = new Gson().toJson(response1);
      myLogger.info(json);
      response.getWriter().write(json);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
