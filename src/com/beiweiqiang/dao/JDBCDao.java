package com.beiweiqiang.dao;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Logger;

public class JDBCDao {
  private static final Logger myLogger = Logger.getLogger("JDBCDao");

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/graduation?useSSL=true&dbnameuseUnicode=true&characterEncoding=utf-8";
  static final String USER = "root";
  static final String PASS = "heanqi";
  private Connection conn;

  public JDBCDao() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ResultSet query(String sql, String[] params) throws SQLException {
    myLogger.info(sql);
    myLogger.info(Arrays.toString(params));
    PreparedStatement pstmt = conn.prepareStatement(sql);
    for (int i = 1; i < params.length + 1; i++) {
      pstmt.setString(i, params[i - 1]);
    }
    return pstmt.executeQuery();
  }

  public int update(String sql, String[] params) throws SQLException {
    myLogger.info(sql);
    myLogger.info(Arrays.toString(params));
    PreparedStatement pstmt = conn.prepareStatement(sql);
    for (int i = 1; i < params.length + 1; i++) {
      pstmt.setString(i, params[i - 1]);
    }
    return pstmt.executeUpdate();
  }


}
