package com.beiweiqiang.dao;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Logger;

public class JDBCDao {
  private static final Logger myLogger = Logger.getLogger("JDBCDao");

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/graduation?useSSL=true";
  static final String USER = "root";
  static final String PASS = "heanqi";
  private Connection conn;

  public JDBCDao() throws ClassNotFoundException, SQLException {
    Class.forName(JDBC_DRIVER);

    conn = DriverManager.getConnection(DB_URL, USER, PASS);

//    Statement stmt = conn.createStatement();

//    String sql = "select * from user";
//    ResultSet rs = stmt.executeQuery(sql);

//    while (rs.next()) {
//      myLogger.info(rs.getInt(1) + ":" + rs.getString("email"));
//    }

//    rs.close();
//    stmt.close();
//    conn.close();
  }

  public ResultSet query(String sql, String[] params) throws SQLException {
    myLogger.info(sql);
    myLogger.info(Arrays.toString(params));
    PreparedStatement pstmt = conn.prepareStatement(sql);
    for (int i = 1; i < params.length + 1; i++) {
      pstmt.setString(i, params[i - 1]);
    }
    ResultSet rs = pstmt.executeQuery();
//    pstmt.close();
    return rs;
  }

}
