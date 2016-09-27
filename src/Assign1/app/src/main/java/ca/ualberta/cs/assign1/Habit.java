package ca.ualberta.cs.assign1;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by orlick on 9/26/16.
 */
public class Habit  {
    private String name;
    private Date date;
    //private ArrayList<Day> dayList = new ArrayList<Day>();

    public Habit(String message){
        this.name = message;
        this.date = new Date();
    }

    public Habit(String message, Date date){
        this.name = message;
        this.date = date;
    }


    @Override
    public String toString() {
        return name;
    }

    public void setName(String newName) {

        this.name = newName;
    }

    public void setDate(Date date) {
        this.date = date;
    }
/*
    public ArrayList<Day> getDayList() {
       return dayList;
    }

    public void setDayList(ArrayList<Day> dayList) {
        this.dayList = dayList;
    }

    public void addDay(Day day) {
        dayList.add(day);
    }
    */
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
