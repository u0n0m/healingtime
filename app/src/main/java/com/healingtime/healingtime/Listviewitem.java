package com.healingtime.healingtime;

/**
 * Created by test on 2017-01-03.
 */

public class Listviewitem {
    private int icon;
    private String name;
    public int getIcon(){return icon;}
    public String getName(){return name;}
    public Listviewitem(int icon,String name){
        this.icon=icon;
        this.name=name;
    }
}