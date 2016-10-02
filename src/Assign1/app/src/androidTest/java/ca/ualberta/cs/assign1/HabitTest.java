package ca.ualberta.cs.assign1;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by orlick on 9/29/16.
 */
public class HabitTest extends ActivityInstrumentationTestCase2 {

    public HabitTest() {
        super(ca.ualberta.cs.assign1.HabitActivity.class);
    }

    public void testRemoveHabit() {
        Habit habit = new Habit("test");
        HabitList list = new HabitList();
        list.addHabit(habit);
        list.deleteHabit(habit);
        assertFalse(list.containsHabit(habit));
    }

    public void testAddHabit() {
        Habit aHabit = new Habit("test");
        HabitList list = new HabitList();
        list.addHabit(aHabit);
        assertEquals(list.getHabit(0), aHabit);
    }

    public void testCompleteAHabit() {
        Habit habit = new Habit("test");
        HabitList list = new HabitList();
        list.addHabit(habit);
        list.completeHabit(habit);
        assertFalse(list.isNotComplete(habit));
    }
    public void testSetDay() {
        Habit habit = new Habit("test");
        HabitList list = new HabitList();
        list.addHabit(habit);
        list.addDay(habit, "monday");
        assertEquals(list.getDay(habit, 0), "monday");
    }


}
