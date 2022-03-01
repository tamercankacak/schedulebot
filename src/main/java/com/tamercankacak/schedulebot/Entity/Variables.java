package com.tamercankacak.schedulebot.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Variables {
  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  public int tutoringId;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String dateStart;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String dateEnd;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String tzname;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  public double durationHours;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  public int limit;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  public int offset;

  public Variables() {}

  public Variables(
      int tutoringId, String dateStart, String dateEnd, String tzname, double durationHours) {
    this.tutoringId = tutoringId;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.tzname = tzname;
    this.durationHours = durationHours;
  }

  public Variables(int limit, int offset) {
    this.limit = limit;
    this.offset = offset;
  }
}
