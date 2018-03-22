package com.beiweiqiang;

import com.beiweiqiang.error.LoginError;
import com.beiweiqiang.model.Response;
import com.beiweiqiang.model.User;
import com.beiweiqiang.service.UserService;
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
import java.util.logging.Logger;

@WebServlet(
        name = "UserLoginServlet",
        urlPatterns = { "/userLogin" }
)
public class UserLoginServlet extends HttpServlet {
  private static final long serialVersionUID = 2L;
  private static final Logger myLogger = Logger.getLogger("UserLoginServlet");

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置字符编码为UTF-8, 这样支持汉字显示
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    /** 设置响应头允许ajax跨域访问 **/
    response.setHeader("Access-Control-Allow-Origin", "*");
    /* 星号表示所有的异域请求都可以接受， */
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");

    User receiveUser = BeanUtils.toBean(JsonReader.receivePost(request), User.class);

    try {
      User user = UserService.login(receiveUser);
      Response response1 = new Response(200, "success", user);
      String json = new Gson().toJson(response1);
      myLogger.info(json);
      response.getWriter().write(json);

    } catch (LoginError e) {
      Response response1 = new Response(e.getCode(), e.getMsg());
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
