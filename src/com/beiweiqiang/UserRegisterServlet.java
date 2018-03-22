package com.beiweiqiang;

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
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(
        name = "UserRegisterServlet",
        urlPatterns = { "/userRegister" }
)
public class UserRegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 3L;
  private static final Logger myLogger = Logger.getLogger("UserRegisterServlet");

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");
    /** 设置响应头允许ajax跨域访问 **/
    response.setHeader("Access-Control-Allow-Origin", "*");
    /* 星号表示所有的异域请求都可以接受， */
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");
    response.setCharacterEncoding("UTF-8");

    User receiveUser = BeanUtils.toBean(JsonReader.receivePost(request), User.class);


    try {
      //    返回错误码
//      0: 成功
//      1001: 已经被注册过
      int code = UserService.register(receiveUser);
      myLogger.info(code + "");
      if (code == 0) {
        Response response1 = new Response(200, "success");
        String json = new Gson().toJson(response1);
        myLogger.info(json);
        response.getWriter().write(json);
      }
      if (code == 1001) {
        Response response1 = new Response(1001, "用户名已经被注册");
        String json = new Gson().toJson(response1);
        myLogger.info(json);
        response.getWriter().write(json);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
