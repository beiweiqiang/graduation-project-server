package com.beiweiqiang;

import com.beiweiqiang.model.ChattingHistory;
import com.beiweiqiang.service.ChattingHistoryService;
import com.beiweiqiang.utils.BeanUtils;
import com.beiweiqiang.utils.ClassCast;
import com.beiweiqiang.utils.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(
        name = "ChattingHistorySaveServlet",
        urlPatterns = { "/chattingHistory/save" }
)
public class ChattingHistorySaveServlet extends HttpServlet {
  private static final Logger myLogger = Logger.getLogger(ChattingHistorySaveServlet.class.getSimpleName());
  private static final long serialVersionUID = 22L;
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
    map.put("createTime", new Timestamp(System.currentTimeMillis()));
    ChattingHistory chattingHistory = BeanUtils.toBean(map, ChattingHistory.class);

    ChattingHistoryService.save(chattingHistory);

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
