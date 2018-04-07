package com.beiweiqiang.service;

import com.beiweiqiang.dao.DataStatisticsDao;
import com.beiweiqiang.model.DataStatistics;
import com.beiweiqiang.utils.ClassCast;

import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

public class DataStatisticsService {
  private static final Logger myLogger = Logger.getLogger(DataStatisticsService.class.getSimpleName());
  private static DataStatisticsDao dataStatisticsDao = new DataStatisticsDao();

  public static Map query(DataStatistics dataStatistics) throws SQLException {
    String s = dataStatisticsDao.query(dataStatistics);
     return ClassCast.stringToMap(s);
  }
}
