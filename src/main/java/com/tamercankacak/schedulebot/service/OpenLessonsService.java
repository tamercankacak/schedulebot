package com.tamercankacak.schedulebot.service;

import com.tamercankacak.schedulebot.Entity.ClientLesson;
import com.tamercankacak.schedulebot.Entity.OpenLesson;

import java.util.List;

public interface OpenLessonsService {
    List<OpenLesson> get();
}
