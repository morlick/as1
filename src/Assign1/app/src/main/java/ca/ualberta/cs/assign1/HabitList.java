package ca.ualberta.cs.assign1;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by orlick on 9/28/16.
 */
public class HabitList {

    private static ArrayList<Habit> habitList = new ArrayList<Habit>();

    public HabitList() {

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
