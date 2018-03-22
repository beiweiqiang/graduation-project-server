package com.beiweiqiang.dao;

import com.beiweiqiang.error.LoginError;
import com.beiweiqiang.error.RegisterError;
import com.beiweiqiang.model.Response;
import com.beiweiqiang.model.User;
import com.beiweiqiang.dao.JDBCDao;
import com.beiweiqiang.utils.CustomError;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDao {
  private static final Logger myLogger = Logger.getLogger("UserDao");
  private JDBCDao jdbcDao;
  private String sql;

  public UserDao() {
    this.jdbcDao = new JDBCDao();
  }

  public User login(User user) throws SQLException {
    sql = "select * from user where username = ? and password = ?";
    String[] params = { user.getUsername(), user.getPassword() };
    ResultSet rs = jdbcDao.query(sql, params);
    try {
      rs.next();
      return new User(
              rs.getInt("id"),
              rs.getString("username"),
              rs.getString("password"),
              rs.getTimestamp("create_time"),
              rs.getTimestamp("last_login_time"));
    } catch (Exception e) {
      throw new LoginError();
    }

  }

  public void register(User user) throws SQLException {
// TODO: 如果未注册, 在数据库插入数据, 跳转回登录页
// TODO: 如果注册过了, 返回错误 已经注册, 错误码
    sql = "select * from user where username = ?";
    String[] params = { user.getUsername() };
    ResultSet rs = jdbcDao.query(sql, params);
    if (rs.isBeforeFirst()) {
//      该用户名已经注册过
      throw new RegisterError();
    } else {
      sql = "insert into `user`(`username`, `password`) values(?, ?)";
      String[] params1 = { user.getUsername(), user.getPassword() };
      int updateCount = jdbcDao.update(sql, params1);
      myLogger.info(updateCount + "");
    }
  }


}
