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
// referenced Student Picker videos while making this


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class HabitActivity extends Activity {
    private EditText bodyText;
    private HabitList hl = new HabitList();
    private ArrayList<String> dayList = new ArrayList<>();
    //private String FILENAME = "file.dat";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit_activity);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.add_habbit_button);


        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                Habit newHabit = new Habit(text);
                for (String day : dayList)
                    newHabit.addDay(day);
                hl.addHabit(newHabit);
            }
        });
        CheckBox monday = (CheckBox) findViewById(R.id.mon);
        monday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Monday")) {
                    dayList.remove("Monday");
                }
                else {
                    dayList.add("Monday");
                }
            }
        });
        CheckBox tuesday = (CheckBox) findViewById(R.id.tues);
        tuesday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Tuesday"))
                    dayList.remove("Tuesday");

                else
                    dayList.add("Tuesday");

            }
        });
        CheckBox wednesday = (CheckBox) findViewById(R.id.wed);
        wednesday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Wednesday"))
                    dayList.remove("Wednesday");

                else
                    dayList.add("Wednesday");

            }
        });
        CheckBox thursday = (CheckBox) findViewById(R.id.thurs);
        thursday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Thursday"))
                    dayList.remove("Thursday");

                else
                    dayList.add("Thursday");

            }
        });
        CheckBox friday = (CheckBox) findViewById(R.id.fri);
        friday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Friday"))
                    dayList.remove("Friday");

                else
                    dayList.add("Friday");

            }
        });
        CheckBox saturday = (CheckBox) findViewById(R.id.sat);
        saturday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Saturday"))
                    dayList.remove("Saturday");

                else
                    dayList.add("Saturday");

            }
        });
        CheckBox sunday = (CheckBox) findViewById(R.id.sun);
        sunday.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if (dayList.contains("Sunday"))
                    dayList.remove("Sunday");

                else
                    dayList.add("Sunday");

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    public void completeHabit(MenuItem menu) {
        Intent intent = new Intent(HabitActivity.this, AddHabitActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        //saveInFile();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //loadFromFile();
    }

/*
    private void loadFromFile() {
        ArrayList<Habit> array = new ArrayList<Habit>();
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-21-2016
            Type listType = new TypeToken<ArrayList<Habit>>() {}.getType();
            array = gson.fromJson(in, listType);
            for (Habit item: array) {
                hl.addHabit(item);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
           // hl = new HabitList();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(hl.getHabitList(), out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    } */
}

