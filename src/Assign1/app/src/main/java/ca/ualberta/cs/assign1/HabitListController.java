package ca.ualberta.cs.assign1;

/**
 * Created by orlick on 9/28/16.
 */
public class HabitListController {
    private static HabitList habitList = null;

    static public HabitList getHabitList() {
        if (habitList == null) {
            habitList = new HabitList();
        }
        return habitList;
    }

    public void addHabit(Habit habit) {
        habitList.addHabit(habit);
    }

    public void deleteHabit(Habit habit) {
        habitList.deleteHabit(habit);
    }
}
