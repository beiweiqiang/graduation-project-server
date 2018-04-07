package com.beiweiqiang.dao;

import com.beiweiqiang.model.DataStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataStatisticsDao {
  private static final Logger myLogger = Logger.getLogger(DataStatisticsDao.class.getSimpleName());
  private JDBCDao jdbcDao;
  private String sql;

  public DataStatisticsDao() {
    this.jdbcDao = new JDBCDao();
  }

  public String query(DataStatistics dataStatistics) throws SQLException {
    int type = dataStatistics.getType();
    int userId = dataStatistics.getUserId();
    sql = "select value from data_statistics where user_id=? and type=? order by create_time desc limit 1;";
    String[] params = { userId + "", type + "" };
    if (type == 0) {
      params[0] = "0";
    }
    ResultSet rs = jdbcDao.query(sql, params);
    rs.next();
    return rs.getString("value");
  }
}
