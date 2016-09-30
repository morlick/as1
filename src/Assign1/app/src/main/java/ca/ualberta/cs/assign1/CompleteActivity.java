package ca.ualberta.cs.assign1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CompleteActivity extends Activity {
    HabitList hl = new HabitList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        Button completeButton = (Button) findViewById(R.id.button_to_complete);


        completeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        int data = getIntent().getExtras().getInt("name");
        Habit habit = hl.getHabit(data);
        TextView myTextView = (TextView) findViewById(R.id.habit_complete_title);
        myTextView.setText("My habit value is " + habit.getName());
        TextView myTextView2 = (TextView) findViewById(R.id.date_complete_title);
        String string = new String();
        string = string.concat("My days are: ");
        for (String day : habit.getDaysToComplete())
            string = string.concat(day+ " ");
        myTextView2.setText(string);




    }

}
