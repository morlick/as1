package ca.ualberta.cs.assign1;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by orlick on 9/28/16.
 */
public class HabitList {

    private static ArrayList<Habit> habitList = new ArrayList<Habit>();

    public HabitList() {

    }

    public int getCompleted(Habit habit) {
        return habit.getCompleted();
    }

    public void increaseCompleted(Habit habit) {
        habit.increaseCompleted();
    }
    public void decreaseCompleted(Habit habit) {
        habit.decreaseCompleted();
    }


    public boolean containsHabit(Habit habit) {
        return habitList.contains(habit);
    }

    public void addHabit(Habit habit) {
        habitList.add(habit);
    }

    public void deleteHabit(Habit habit) {
        habitList.remove(habit);
    }

    public Habit getHabit(int index) {
        return habitList.get(index);

    }

    public Date getDate(Habit habit) {
        return habit.getDate();
    }

    public void setDate(Habit habit,Date date) {
        habit.setDate(date);
    }

    public ArrayList<Date> getDaysComplete(Habit habit) {
        return habit.getDaysComplete();
    }

    public void setDaysComplete(ArrayList<Date> daysComplete, Habit habit) {
        habit.setDaysComplete(daysComplete);
    }

    public void completeHabit(Habit habit) {
        int i = habitList.indexOf(habit);
        habitList.get(i).complete();
    }
    public boolean isNotComplete(Habit habit) {
        int i = habitList.indexOf(habit);
        return habitList.get(i).isNotComplete();
    }

    public ArrayList<Habit> getHabitList() {
        return habitList;
    }

    public void addDay(Habit habit, String day) {
        habit.addDay(day);
    }

    public String getDay(Habit habit, int index) {
        ArrayList<String> list;
        list = habit.getDaysToComplete();
        return list.get(index);

    }
}