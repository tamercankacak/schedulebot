package com.tamercankacak.schedulebot.Entity.OpenLessons;

public class OpenLessonRequest {
  public Variables variables;
  public String query;

  public OpenLessonRequest(Variables variables, String query) {
    this.variables = variables;
    this.query = query;
  }
}
