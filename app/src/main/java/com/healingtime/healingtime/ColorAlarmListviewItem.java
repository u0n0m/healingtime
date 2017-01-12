package com.healingtime.healingtime;

import android.graphics.drawable.Drawable;

public class ColorAlarmListviewItem {

    private String start_ampm;
    private String start_hour_min;
    private String end_ampm;
    private String end_hour_min;
    private String week;
    private String bright;
    private String type;
    private Drawable img_btn;

    public String getEnd_ampm() {
        return end_ampm;
    }

    public void setEnd_ampm(String end_ampm) {
        this.end_ampm = end_ampm;
    }

    public String getStart_ampm() {
        return start_ampm;
    }

    public void setStart_ampm(String start_ampm) {
        this.start_ampm = start_ampm;
    }

    public String getStart_hour_min() {
        return start_hour_min;
    }

    public void setStart_hour_min(String start_hour_min) {
        this.start_hour_min = start_hour_min;
    }

    public String getEnd_hour_min() {
        return end_hour_min;
    }

    public void setEnd_hour_min(String end_hour_min) {
        this.end_hour_min = end_hour_min;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getBright() {
        return bright;
    }

    public void setBright(Integer bright) {
        this.bright = "밝기: " + bright * 10 + "%";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Drawable getImg_btn() {
        return img_btn;
    }

    public void setImg_btn(Drawable img_btn) {
        this.img_btn = img_btn;
    }

}
