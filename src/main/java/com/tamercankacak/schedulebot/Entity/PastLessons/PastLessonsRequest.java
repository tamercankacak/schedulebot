package com.tamercankacak.schedulebot.Entity.PastLessons;

public class PastLessonsRequest {
  public String operationName;
  public Variables variables;
  public String query;

  public PastLessonsRequest(String operationName, Variables variables, String query) {
    this.operationName = operationName;
    this.variables = variables;
    this.query = query;
  }
}
