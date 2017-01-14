package com.healingtime.healingtime;

import android.graphics.drawable.Drawable;

public class aromaAlarmListviewItem {

    private Integer aroma_type;
    private String start_ampm;
    private String start_hour_min;
    private String end_ampm;
    private String end_hour_min;
    private String week;
    private Integer repeat_cycle;
    private Integer remain_amount;

    public Drawable getAroma_alarm_onoff() {
        return aroma_alarm_onoff;
    }

    public void setAroma_alarm_onoff(Drawable aroma_alarm_onoff) {
        this.aroma_alarm_onoff = aroma_alarm_onoff;
    }

    private Drawable aroma_alarm_onoff;

    public Integer getRemain_amount() {
        return remain_amount;
    }

    public void setRemain_amount(Integer remain_amount) {
        this.remain_amount = remain_amount;
    }

    public Integer getRepeat_cycle() {
        return repeat_cycle;
    }

    public void setRepeat_cycle(Integer repeat_cycle) {
        this.repeat_cycle = repeat_cycle;
    }

    public Integer getAroma_type() {
        return aroma_type;
    }

    public void setAroma_type(Integer aroma_type) {
        this.aroma_type = aroma_type;
    }

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

}
