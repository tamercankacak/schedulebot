package com.tamercankacak.schedulebot.service.impl;

import com.tamercankacak.schedulebot.Client.LessonClient;
import com.tamercankacak.schedulebot.config.AppConfig;

import java.io.IOException;

public class ScheduleServiceImpl {
  private AppConfig config;
  private LessonClient lessonClient;

  public ScheduleServiceImpl() throws IOException {
    config = AppConfig.load();
    lessonClient = new LessonClient(config.cookie);
  }

  public void schedule() {}
}
