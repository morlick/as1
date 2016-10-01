package ca.ualberta.cs.assign1;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by orlick on 9/26/16.
 *
 * This is a habit object.
 *
 */
public class Habit  {
    private String name;
    private ArrayList<Date> daysComplete = new ArrayList<Date>();
    private ArrayList<String> daysToComplete = new ArrayList<String>();
    private Date date;
    private int completed = 0;
//creates a habit with user provided date and habit
    public Habit(String name, Date date) {
        this.name = name;
        this.date = date;
    }
    //creeates habit with string habit and auto filled date
    public Habit(String message){
        this.date = new Date();
        this.name = message;
    }
    //returns number of completions
    public int getCompleted() {
        return completed;
    }

    //adds a day to be completed to habit
    public void addDay(String day) {
        daysToComplete.add(day);
    }
    //returns list of days to be completed
    public ArrayList<String> getDaysToComplete() {
        return daysToComplete;
    }
    //returns creation date
    public Date getDate() {
        return date;
    }
    //sets creation date
    public void setDate(Date date) {
        this.date = date;
    }
    //reutns list of days that are completed
    public ArrayList<Date> getDaysComplete() {
        return daysComplete;
    }
    //sets the list of complete days
    public void setDaysComplete(ArrayList<Date> daysComplete) {
        this.daysComplete = daysComplete;
    }
    //sets list of days to complete
    public void setDaysToComplete(ArrayList<String> daysToComplete) {
        this.daysToComplete = daysToComplete;
    }
    //returns habit sting
    @Override
    public String toString() {
        return name;
    }
    //sets habit sting
    public void setName(String newName) {

        this.name = newName;    }

    //returns string of habit
    public String getName() {
        return name;
    }
    //adds a date that the habit was completed on
    public void complete() {
        daysComplete.add(new Date());
    }
    //retursn true if ahbit it not complete
    public boolean isNotComplete() {
        return daysComplete.isEmpty();
    }
    //increases complete count when habit is completed
    public void increaseCompleted() {
        completed += 1;
    }
    //decreases count when completion is deleted
    public void decreaseCompleted() {
        completed -= 1;
    }
}
