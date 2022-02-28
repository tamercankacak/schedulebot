package com.tamercankacak.schedulebot.Entity.UpcomingLessons;

public class UpcomingLessonsRequest {
  public String operationName;
  public Variables variables;
  public String query;

  public UpcomingLessonsRequest(String operationName, Variables variables, String query) {
    this.operationName = operationName;
    this.variables = variables;
    this.query = query;
  }
}
