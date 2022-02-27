package com.tamercankacak.schedulebot.Entity.OpenLessons;

public class Request {
  public Variables variables;
  public String query;

  public Request(Variables variables, String query) {
    this.variables = variables;
    this.query = query;
  }
}
