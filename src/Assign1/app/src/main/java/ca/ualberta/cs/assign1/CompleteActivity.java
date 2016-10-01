package ca.ualberta.cs.assign1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
This shows a list of completions of habits.
the user can complete the ahbit or delete the record of completion.

*/


public class CompleteActivity extends Activity {
    private HabitList hl = new HabitList();
    private ListView oldCompletions;
    private ArrayList<Date> dateList = new ArrayList<Date>();
    private ArrayAdapter<Date> adapter;
    private Habit myHabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);


        oldCompletions = (ListView) findViewById(R.id.listView);
        Button completeButton = (Button) findViewById(R.id.button_to_complete);

        //completes the habit
        //adds the date of completion to list view
        //increments completion count
        completeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                Date date = new Date();
                dateList.add(date);
                hl.setDaysComplete(dateList, myHabit);
                hl.increaseCompleted(myHabit);
                adapter.notifyDataSetChanged();
                TextView myTextView3 = (TextView) findViewById(R.id.times_completed);
                myTextView3.setText("Number of times completed: " + hl.getCompleted(myHabit));
            }
        });

        //user can delete the habit by pressing and holding
        //they are prompted to delete or cancel
        oldCompletions.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(CompleteActivity.this);
                adb.setMessage("Delete "+dateList.get(position).toString()+"?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener(){

                    //delete button
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date date = dateList.get(finalPosition);
                        dateList.remove(date);
                        hl.decreaseCompleted(myHabit);
                        adapter.notifyDataSetChanged();
                        TextView myTextView3 = (TextView) findViewById(R.id.times_completed);
                        myTextView3.setText("Number of times completed: " + hl.getCompleted(myHabit));

                    }
                });

                //cancel button
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
                return false;
            }
        });

    }
    @Override
    public void onPause() {
        super.onPause();
    }



    @Override
    protected void onStart() {
        super.onStart();

        //adds titles to screen
        //these change depending on the habit the user is viewing
        int data = getIntent().getExtras().getInt("name");
        Habit habit = hl.getHabit(data);
        myHabit = habit;
        dateList = hl.getDaysComplete(habit);
        TextView myTextView = (TextView) findViewById(R.id.habit_complete_title);
        myTextView.setText("My habit value is " + habit.getName());
        TextView myTextView2 = (TextView) findViewById(R.id.date_complete_title);
        String string = new String();
        string = string.concat("My days are: ");
        for (String day : habit.getDaysToComplete())
            string = string.concat(day+ " ");
        myTextView2.setText(string);
        TextView myTextView3 = (TextView) findViewById(R.id.times_completed);
        myTextView3.setText("Number of times completed: " + hl.getCompleted(habit));

        adapter = new ArrayAdapter<Date>(this,  R.layout.list_item_2, dateList);
        oldCompletions.setAdapter(adapter);
    }

}
