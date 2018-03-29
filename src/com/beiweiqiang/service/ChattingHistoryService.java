package com.beiweiqiang.service;

import com.beiweiqiang.dao.ChattingHistoryDao;
import com.beiweiqiang.model.ChattingHistory;

import java.sql.SQLException;
import java.util.logging.Logger;

public class ChattingHistoryService {
  private static final Logger myLogger = Logger.getLogger(ChattingHistoryService.class.getSimpleName());
  private static ChattingHistoryDao chattingHistoryDao = new ChattingHistoryDao();

  public static void save(ChattingHistory chattingHistory) {
    String originContent = chattingHistory.getOriginContent();
    String originTitle = chattingHistory.getOriginTitle();
    if (originContent.contains(":")) {
      String[] strings = originContent.split(": ");
      if (strings[0].contains(originTitle)) {
//        为 个人多条
        chattingHistory.setMessageType(0);
        chattingHistory.setFromWho(originTitle);
        chattingHistory.setMessageContent(strings[1]);
      } else {
//        可能为多条群聊 或 单条群聊
        chattingHistory.setGroupName(originTitle);
        chattingHistory.setMessageType(1);
        chattingHistory.setMessageContent(strings[1]);
        if (strings[0].contains("]")) {
//          多条群聊
          chattingHistory.setFromWho(strings[0].replaceAll("\\[.*\\]", ""));
        } else {
//          单条群聊
          chattingHistory.setFromWho(strings[0]);
        }
      }
    } else {
//      如果不包含冒号, 肯定是个人单条记录
      chattingHistory.setMessageType(0);
      chattingHistory.setFromWho(originTitle);
      chattingHistory.setMessageContent(originContent);
    }

    myLogger.info(chattingHistory.toString());
    try {
      chattingHistoryDao.save(chattingHistory);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
