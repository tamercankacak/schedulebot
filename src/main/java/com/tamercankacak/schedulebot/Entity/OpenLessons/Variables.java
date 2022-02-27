package com.tamercankacak.schedulebot.Entity.OpenLessons;

public class Variables {
  public int tutoringId;
  public String dateStart;
  public String dateEnd;
  public String tzname;
  public double durationHours;

  public Variables(
      int tutoringId, String dateStart, String dateEnd, String tzname, double durationHours) {
    this.tutoringId = tutoringId;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.tzname = tzname;
    this.durationHours = durationHours;
  }
}
