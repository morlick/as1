package ca.ualberta.cs.assign1;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by orlick on 9/28/16.
 *
 * This is the list of habits
 *  Interactions with current habits are through this
 */
public class HabitList {

    private static ArrayList<Habit> habitList = new ArrayList<Habit>();

    public HabitList() {

    }
    //returns completed habit
    public int getCompleted(Habit habit) {
        return habit.getCompleted();
    }
    //increases completed count when a completetion happens
    public void increaseCompleted(Habit habit) {
        habit.increaseCompleted();
    }
    //decreases completion count when a completion is deleted
    public void decreaseCompleted(Habit habit) {
        habit.decreaseCompleted();
    }

    //returns true is the list contains the habit
    public boolean containsHabit(Habit habit) {
        return habitList.contains(habit);
    }
    //adds a habit
    public void addHabit(Habit habit) {
        habitList.add(habit);
    }
    //deletes a habit
    public void deleteHabit(Habit habit) {
        habitList.remove(habit);
    }
    //gets the habit at the index
    public Habit getHabit(int index) {
        return habitList.get(index);

    }

    //returns date habit was created on
    public Date getDate(Habit habit) {
        return habit.getDate();
    }
    //sets the date the habit was created on
    public void setDate(Habit habit,Date date) {
        habit.setDate(date);
    }
    //returns list of dates the habit was completed on
    public ArrayList<Date> getDaysComplete(Habit habit) {
        return habit.getDaysComplete();
    }
    //sets dates the habits was completed on
    public void setDaysComplete(ArrayList<Date> daysComplete, Habit habit) {
        habit.setDaysComplete(daysComplete);
    }
    //complete the habit
    public void completeHabit(Habit habit) {
        int i = habitList.indexOf(habit);
        habitList.get(i).complete();
    }
    //returns true is not complete
    public boolean isNotComplete(Habit habit) {
        int i = habitList.indexOf(habit);
        return habitList.get(i).isNotComplete();
    }
    //returns the habit list
    public ArrayList<Habit> getHabitList() {
        return habitList;
    }
    //adds a day to be comlpeted to the habit
    public void addDay(Habit habit, String day) {
        habit.addDay(day);
    }
    //returns the days to be completed at the index
    public String getDay(Habit habit, int index) {
        ArrayList<String> list;
        list = habit.getDaysToComplete();
        return list.get(index);
    }
}