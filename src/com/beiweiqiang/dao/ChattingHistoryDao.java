package com.beiweiqiang.dao;

import com.beiweiqiang.model.ChattingHistory;

import java.sql.SQLException;
import java.util.logging.Logger;

public class ChattingHistoryDao {
  private static final Logger myLogger = Logger.getLogger(ChattingHistoryDao.class.getSimpleName());
  private JDBCDao jdbcDao;
  private String sql;

  public ChattingHistoryDao() {
    this.jdbcDao = new JDBCDao();
  }

  public void save(ChattingHistory chattingHistory) throws SQLException {
    sql = "INSERT INTO user_chatting_history (user_id, from_who, message_content, message_type, group_name, origin_title, origin_content) VALUES (?, ?, ?, ?, ?, ?, ?);";
    String[] params = { chattingHistory.getUserId() + "", chattingHistory.getFromWho(), chattingHistory.getMessageContent(), chattingHistory.getMessageType() + "", chattingHistory.getGroupName(), chattingHistory.getOriginTitle(), chattingHistory.getOriginContent() };
    int updateCount = jdbcDao.update(sql, params);
    myLogger.info(updateCount + "");
  }
}
