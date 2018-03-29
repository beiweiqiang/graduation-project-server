package com.beiweiqiang.dao;

import com.beiweiqiang.model.ChattingHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

  public ArrayList<String> getAllGroupName(ChattingHistory chattingHistory) throws SQLException {
    sql = "SELECT group_name FROM user_chatting_history WHERE user_id=?;";
    String[] params = { chattingHistory.getUserId() + "" };
    ArrayList<String> groupNameArray = new ArrayList<>();
//    try {
      ResultSet resultSet = jdbcDao.query(sql, params);
      while (resultSet.next()) {
//        myLogger.info(resultSet.getString("group_name"));
        groupNameArray.add(resultSet.getString("group_name"));
      }
      myLogger.info(groupNameArray.toString());
      return groupNameArray;
  }
}
