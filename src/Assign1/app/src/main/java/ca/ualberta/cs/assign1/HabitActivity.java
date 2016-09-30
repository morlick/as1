/*
Habit Tracker: User can add and complete habits.

Copyright (C) 2016 Margaret Orlick

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package ca.ualberta.cs.assign1;

// lonely twitter code from https://github.com/joshua2ua/lonelyTwitter


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class HabitActivity extends Activity {
    private EditText bodyText;
    private HabitList hl = new HabitList();
    private ArrayList<Habit> habitList = new ArrayList<>();
    private ArrayList<String> dayList = new ArrayList<>();


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit_activity);

        bodyText = (EditText) findViewById(R.id.body);
        habitList = hl.getHabitList();
        Button saveButton = (Button) findViewById(R.id.add_habbit_button);


        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                Habit newHabit = new Habit(text);
                newHabit.getName();
                for (String day : dayList)
                    newHabit.addDay(day);
                habitList.add(newHabit);
                hl.addHabit(newHabit);
            }
        });
        CheckBox monday = (CheckBox) findViewById(R.id.mon);
        monday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("monday")) {
                    dayList.remove("monday");
                    Toast.makeText(getApplicationContext(), "remove", Toast.LENGTH_SHORT).show();
                }
                else {
                    dayList.add("monday");
                    Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox tuesday = (CheckBox) findViewById(R.id.tues);
        tuesday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("tuesday"))
                    dayList.remove("tuesday");

                else
                    dayList.add("tuesday");

            }
        });
        CheckBox wednesday = (CheckBox) findViewById(R.id.wed);
        wednesday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("wednesday"))
                    dayList.remove("wednesday");

                else
                    dayList.add("wednesday");

            }
        });
        CheckBox thursday = (CheckBox) findViewById(R.id.thurs);
        thursday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("thursday"))
                    dayList.remove("thursday");

                else
                    dayList.add("thursday");

            }
        });
        CheckBox friday = (CheckBox) findViewById(R.id.fri);
        friday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("friday"))
                    dayList.remove("friday");

                else
                    dayList.add("friday");

            }
        });
        CheckBox saturday = (CheckBox) findViewById(R.id.sat);
        saturday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("saturday"))
                    dayList.remove("saturday");

                else
                    dayList.add("saturday");

            }
        });
        CheckBox sunday = (CheckBox) findViewById(R.id.sun);
        sunday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("sunday"))
                    dayList.remove("sunday");

                else
                    dayList.add("sunday");

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    public void completeHabit(MenuItem menu) {
        Toast.makeText(this,"add habit" , Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent(HabitActivity.this, AddHabitActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }


}
