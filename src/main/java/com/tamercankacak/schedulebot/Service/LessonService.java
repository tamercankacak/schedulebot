package com.tamercankacak.schedulebot.Service;

import com.tamercankacak.schedulebot.Entity.OpenLessons.Request;
import com.tamercankacak.schedulebot.Entity.OpenLessons.Variables;
import com.tamercankacak.schedulebot.config.AppConfig;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LessonService {
  private AppConfig config;

  public LessonService() throws IOException {
    config = AppConfig.load();
  }

  public void getOpenLessons() {
    String dateStart = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    String dateEnd =
        new SimpleDateFormat("dd-MM-yyyy")
            .format(new Date(new Date().getTime() + (1000L * 60 * 60 * 24 * config.dayLength)));

    Request request =
        new Request(
            new Variables(
                config.tutoringId, dateStart, dateEnd, "Europe/Moscow", config.durationHours),
            config.openLessonsQuery);
  }
}
