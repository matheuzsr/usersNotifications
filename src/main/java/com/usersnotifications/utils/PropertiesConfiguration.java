package com.usersnotifications.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class PropertiesConfiguration {
  private Properties properties;
  private File file;

  public PropertiesConfiguration() {
    this.properties = new Properties();
    this.file = new File("./config/project.properties");

    try (FileReader f = new FileReader(file)) {
      this.properties.load(f);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getProperty(String props) {
    return this.properties.getProperty(props);
  }

  public void setProperty(String key, String prop) throws Exception {
    properties.setProperty(key, prop);

    try (FileWriter f = new FileWriter(file);) {
      properties.store(f, null);
    } catch (Exception e) {
      throw new Exception("Problema ao escrever no arquivo de propriedade");
    }
  }
}