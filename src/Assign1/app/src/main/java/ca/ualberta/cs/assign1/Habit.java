package ca.ualberta.cs.assign1;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by orlick on 9/26/16.
 */
public class Habit  {
    private String name;
    private ArrayList<Date> daysComplete = new ArrayList<Date>();
    private ArrayList<String> daysToComplete = new ArrayList<>();


    public Habit(String message){
        this.name = message;
    }

    public void addDay(String day) {
        daysToComplete.add(day);
    }

    public ArrayList<String> getDaysToComplete() {
        return daysToComplete;
    }


    @Override
    public String toString() {
        return name;
    }

    public void setName(String newName) {

        this.name = newName;    }


    public String getName() {
        return name;
    }

    public void complete() {
        daysComplete.add(new Date());
    }

    public boolean isNotComplete() {
        return daysComplete.isEmpty();
    }
}
