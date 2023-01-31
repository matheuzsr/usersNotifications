package com.usersnotifications.utils;

import java.util.Properties;

import com.ufes.exercicio.log.CSVLogAdapter;
import com.ufes.exercicio.log.JSONLogAdapter;
import com.ufes.exercicio.log.LogAdapter;
import com.ufes.exercicio.model.RegistroLog;
import com.ufes.exercicio.services.LogService;

public class LoggerService {
  private static LoggerService instance;
  private static LogService logService;
  private PropertiesConfiguration propertiesConfiguration;
  private String filePath = "./log/log";

  public static String INCLUDE = "INCLUSAO";
  public static String CHANGE = "ALTERACAO";
  public static String DELETE = "EXCLUSAO USUARIO";
  public static String READING_NOTIFICATION = "LEITURA NOTIFICACAO";

  private LoggerService() {
    this.propertiesConfiguration = new PropertiesConfiguration();
    logService = new LogService(null);

    String logType = propertiesConfiguration.getProperty("FILETYPE_LOG");
    this.setLogService(logType);
  }

  public static LoggerService getInstance() throws Exception {
    if (instance == null) {
      instance = new LoggerService();
    }

    return instance;
  }

  public void write(String type, String information, String user) throws Exception {
    logService.escrever(new RegistroLog(type, information, user));
  }

  public void setLogService(String type) {
    if (type.equalsIgnoreCase("csv")) {
      this.setAdapterLog(new CSVLogAdapter(this.filePath), type);

      return;
    } else if (type.equalsIgnoreCase("json")) {
      this.setAdapterLog(new JSONLogAdapter(this.filePath), type);

      return;
    }
  }

  private void setAdapterLog(LogAdapter adapter, String type) {
    try {
      this.propertiesConfiguration.setProperty("FILETYPE_LOG", type);
      logService.setLog(adapter);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}