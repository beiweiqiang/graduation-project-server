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

  public String queryWordFrequency(DataStatistics dataStatistics) throws SQLException {
    return query(dataStatistics, "wordFrequency");
  }

  public String queryGroupChattingFrenquencyFrequency(DataStatistics dataStatistics) throws SQLException {
    return query(dataStatistics, "groupChattingFrenquency");
  }

  private String query(DataStatistics dataStatistics, String type) throws SQLException {
    sql = "SELECT `value` FROM data_statistics WHERE user_id=? AND type=? ORDER BY create_time DESC LIMIT 1;";
    String[] params = { dataStatistics.getUserId() + "", type };
    ResultSet rs = jdbcDao.query(sql, params);
    rs.next();
    return rs.getString("value");
  }
}
