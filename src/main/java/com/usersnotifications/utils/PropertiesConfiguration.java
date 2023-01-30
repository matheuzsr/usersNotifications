package com.usersnotifications.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesConfiguration {
  private Properties properties;

  public PropertiesConfiguration() {
    this.properties = new Properties();

    File file = new File(
        "./project.properties");

    try (FileReader f = new FileReader(file)) {
      this.properties.load(f);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getProperties(String props) {
    return this.properties.getProperty(props);
  }
}