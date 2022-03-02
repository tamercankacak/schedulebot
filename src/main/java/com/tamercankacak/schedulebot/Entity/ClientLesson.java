package com.tamercankacak.schedulebot.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientLesson {
  public int id;
  public Date datetime;
  public double duration;
  public String status;
}
