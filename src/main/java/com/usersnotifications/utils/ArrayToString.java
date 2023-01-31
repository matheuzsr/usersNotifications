package com.usersnotifications.utils;

public class ArrayToString {
  public static String convert(String arrayString) {
    String arrayStringClearing = arrayString.substring(1, arrayString.length() - 1);

    return arrayStringClearing.replace(";,", ";\n");
  }
}