package com.tamercankacak.schedulebot.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppConfig {
  public int tutoringId;
  public int dayLength;
  public double durationHours;
  public String openLessonsQuery;
  public String upcomingLessonsQuery;
  public String cookie;


  public static AppConfig load() throws IOException {
    String config = new String(Files.readAllBytes(Paths.get("src/main/resources/AppConfig.json")));
    AppConfig appConfig = new ObjectMapper().readValue(config, AppConfig.class);
    return appConfig;
  }
}
