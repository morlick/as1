package ca.ualberta.cs.assign1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by orlick on 9/28/16.
 */
public class HabitList {

    protected ArrayList<Habit> habitList;

    public HabitList() {
        habitList = new ArrayList<Habit>();
    }

    public Collection<Habit> getHabitList(){
        return habitList;
    };
    public void addHabit(Habit habit) {
        habitList.add(habit);

    }

}
