package ca.ualberta.cs.assign1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddHabitActivity extends Activity {

    private EditText bodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit_activity);


        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.add_habbit_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              setResult(RESULT_OK);
                                              String text = bodyText.getText().toString();
                                              Habit newHabit = new Habit(text);
                                              newHabit.getName();
                                              HabitListController hlc = new HabitListController();
                                              hlc.addHabit(newHabit);

                                          }
                                      }
        );

    }

}
