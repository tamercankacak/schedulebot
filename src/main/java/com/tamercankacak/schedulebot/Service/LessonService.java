package com.tamercankacak.schedulebot.Service;

import com.tamercankacak.schedulebot.Entity.OpenLessons.OpenLessonRequest;
import com.tamercankacak.schedulebot.Entity.OpenLessons.Variables;
import com.tamercankacak.schedulebot.config.AppConfig;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

    OpenLessonRequest openLessonRequest =
        new OpenLessonRequest(
            new Variables(
                config.tutoringId, dateStart, dateEnd, "Europe/Moscow", config.durationHours),
            config.openLessonsQuery);
  }
}
