package ca.ualberta.cs.assign1;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by orlick on 9/26/16.
 */
public class Habit  {
    private String name;
    private ArrayList<Date> days = new ArrayList<Date>();



    public Habit(String message){
        this.name = message;

    }


    @Override
    public String toString() {
        return name;
    }

    public void setName(String newName) {

        this.name = newName;
    }


    public String getName() {
        return name;
    }

    public void complete() {
        days.add(new Date());
    }

    public boolean isNotComplete() {
        return days.isEmpty();
    }
}
