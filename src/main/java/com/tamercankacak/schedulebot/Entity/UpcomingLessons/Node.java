package com.tamercankacak.schedulebot.Entity.UpcomingLessons;

import java.util.Date;

public class Node {
  public int id;
  public Date datetime;
  public double duration;
  public String status;
  public String paidAmount;
  public boolean hasIssue;
  public Tutor tutor;
  public Tutoring tutoring;
  public Object recurrentLessonConfig;
  public Object rating;
  public AutoConfirmationInfo autoConfirmationInfo;
  public String __typename;
}
