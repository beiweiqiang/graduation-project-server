package com.beiweiqiang.service;

import com.beiweiqiang.dao.UserDao;
import com.beiweiqiang.model.User;

import java.sql.SQLException;

public class UserLoginService {
  public User login(String username, String password) throws SQLException, ClassNotFoundException {
    UserDao userDao = new UserDao();
    return userDao.checkLogin(username, password);
  }
}
