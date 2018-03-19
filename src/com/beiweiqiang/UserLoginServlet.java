package com.beiweiqiang;

import com.beiweiqiang.model.Response;
import com.beiweiqiang.model.User;
import com.beiweiqiang.service.UserLoginService;
import com.google.gson.Gson;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        name = "UserLoginServlet",
        urlPatterns = { "/userLogin" }
)
public class UserLoginServlet extends HttpServlet {
  private static final long serialVersionUID = 2L;
  private static final Logger myLogger = Logger.getLogger("UserLoginServlet");
  private UserLoginService userLoginService = new UserLoginService();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // response.setContentType("text/html");
    // 设置字符编码为UTF-8, 这样支持汉字显示
    // response.setCharacterEncoding("UTF-8");

//    response.setContentType("text/html;charset=utf-8");
    response.setContentType("application/json");
    /** 设置响应头允许ajax跨域访问 **/
    response.setHeader("Access-Control-Allow-Origin", "*");
    /* 星号表示所有的异域请求都可以接受， */
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");

//    JSONObject json = new JSONObject(request.getParameter("username"));
//    JSONObject json = JsonReader.receivePost(request);
    Map<String, Object> obj = JsonReader.receivePost(request);
    String username = obj.get("username").toString();
    String password = obj.get("password").toString();

    try {
      User user = userLoginService.login(username, password);
      Response response1 = new Response(200, "success", user);
      String json = new Gson().toJson(response1);
      myLogger.info(json);
      response.getWriter().write(json);

    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    //将建json对象转换为java对象
//    User loginUser = (User) JSONObject.toBean(json, User.class);
//    User user = userService.LoginUser(loginUser);
//    JSONObject jsonObject = new JSONObject();
//    if (user != null) {
      //将java对象转换为json对象
//      jsonObject.put("user", JSONObject.fromObject(user));
//      jsonObject.put("message", "用户登录成功！");
//    } else {
//
//      jsonObject.put("message", "用户登录失败！");
//    }
//    out.write(jsonObject.toString());
//    out.flush();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
