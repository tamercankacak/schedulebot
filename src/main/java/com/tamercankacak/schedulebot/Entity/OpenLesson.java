package com.tamercankacak.schedulebot.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLesson {
  public Date dateStart;
  public Date dateEnd;
  public boolean isFree;
}
