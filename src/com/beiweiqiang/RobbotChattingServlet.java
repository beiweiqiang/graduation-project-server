package com.beiweiqiang;

import com.beiweiqiang.error.LoginError;
import com.beiweiqiang.model.UserQuestion;
import com.beiweiqiang.service.ChattingService;
import com.beiweiqiang.utils.BeanUtils;
import com.beiweiqiang.utils.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(
        name = "RobbotChattingServlet",
        urlPatterns = { "/robbotChatting" }
)
public class RobbotChattingServlet extends HttpServlet {
  private static final Logger myLogger = Logger.getLogger(RobbotChattingServlet.class.getSimpleName());
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置字符编码为UTF-8, 这样支持汉字显示
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    /** 设置响应头允许ajax跨域访问 **/
    response.setHeader("Access-Control-Allow-Origin", "*");
    /* 星号表示所有的异域请求都可以接受， */
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");

    UserQuestion userQuestion = BeanUtils.toBean(JsonReader.receivePost(request), UserQuestion.class);

    String text = ChattingService.question(userQuestion);
    try {
      String jsonStr = String.format("{\n" +
              "\t\"text\": \"%s\"\n" +
              "}", text);
      response.getWriter().write(jsonStr);

    } catch (LoginError e) {
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
