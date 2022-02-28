package com.tamercankacak.schedulebot.Entity.PastLessons;

import java.util.Date;

public class Node{
    public int id;
    public Date datetime;
    public double duration;
    public String status;
    public String paidAmount;
    public boolean hasIssue;
    public Tutor tutor;
    public Tutoring tutoring;
    public Rating rating;
    public Object autoConfirmationInfo;
    public String __typename;
}
