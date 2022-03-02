package com.tamercankacak.schedulebot.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestUtil {

  public static JsonNode parseJSON(String jsonBody, String[] values) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode jsonNode = mapper.readTree(jsonBody);
      for (String value : values) {
        jsonNode = jsonNode.get(value);
      }
      return jsonNode;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
