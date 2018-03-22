package com.beiweiqiang.service;

import com.beiweiqiang.dao.UserDao;
import com.beiweiqiang.model.User;

import java.sql.SQLException;

public class UserService {

  private static UserDao userDao = new UserDao();

  public static User login(User user) throws SQLException {
    return userDao.login(user);
  }

  public static int register(User user) throws SQLException {
    return userDao.register(user);
  }
}
