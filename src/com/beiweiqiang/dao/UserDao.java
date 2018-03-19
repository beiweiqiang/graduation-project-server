package com.beiweiqiang.dao;

import com.beiweiqiang.model.User;
import com.beiweiqiang.dao.JDBCDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDao {
  private static final Logger myLogger = Logger.getLogger("UserDao");

  public User checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
    String sql = "select * from user where username = ? and password = ?";
    String[] params = { username, password };
    JDBCDao jdbcDao = new JDBCDao();
    ResultSet rs = jdbcDao.query(sql, params);
    rs.next();
//    myLogger.info( rs.getString("create_time"));
    return new User(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getTimestamp("create_time"),
            rs.getTimestamp("last_login_time"));
  }

//  public User register(String username, String password) {
//
//  }


}
