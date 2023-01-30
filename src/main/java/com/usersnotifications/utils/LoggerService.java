package com.usersnotifications.utils;

import java.util.Properties;

import com.ufes.exercicio.log.CSVLogAdapter;
import com.ufes.exercicio.log.JSONLogAdapter;
import com.ufes.exercicio.model.RegistroLog;
import com.ufes.exercicio.services.LogService;

public class LoggerService {
  private static LoggerService instance;
  private static LogService logService;
  private String filePath = "./log/log";

  public static String INCLUDE = "INCLUSAO";
  public static String CHANGE = "ALTERACAO";
  public static String DELETE = "EXCLUSAO USUARIO";
  public static String READING_NOTIFICATION = "LEITURA NOTIFICACAO";

  private LoggerService() {
    logService = new LogService(new JSONLogAdapter(this.filePath));
  }

  public static LoggerService getInstance() throws Exception {
    if (instance == null) {
      instance = new LoggerService();
    }

    if (logService == null) {
      throw new Exception("Selecione usando o método `setLogService` ");
    }

    return instance;
  }

  public void write(String type, String information, String user) throws Exception {
    logService.escrever(new RegistroLog(type, information, user));
  }

  public void setLogService(String type) {
    if (type.equalsIgnoreCase("csv")) {
      logService.setLog(new CSVLogAdapter(this.filePath));

      return;
    } else if (type.equalsIgnoreCase("json")) {
      logService.setLog(new JSONLogAdapter(this.filePath));

      return;
    }
    throw new RuntimeException("Informe um tipo válido de log: csv ou json");
  }
}