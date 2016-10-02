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

/*
This deals with adding a habit and selecting the days to complete it on

 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HabitActivity extends Activity {
    private EditText bodyText;
    private EditText dateText;
    private HabitList hl = new HabitList();
    private ArrayList<String> dayList = new ArrayList<>();
    private String FILENAME = "file.json";
    private ArrayList<Habit> myHabitList = new ArrayList<>();
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    private Date date;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit_activity);

        bodyText = (EditText) findViewById(R.id.body);
        dateText = (EditText) findViewById(R.id.edit_date);
        Button saveButton = (Button) findViewById(R.id.add_habbit_button);

        //deals with adding a habit
        //if the user does not enter a date, the current date is autofilled
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                if (!dateText.getText().toString().equals("Enter a Date or Autofill" )) {
                    // code from http://stackoverflow.com/questions/17674308/date-from-edittext
                    try {
                        date = df.parse(dateText.getText().toString());
                        String myText = date.getYear() + "-" + (date.getMonth() + 1) + "-" + (1900 + date.getDay());
                    } catch (ParseException e) {
                        date = new Date();
                    }
                }
                else
                    date = new Date();

                Habit newHabit = new Habit(text, date);
                for (String day : dayList)
                    newHabit.addDay(day);
                hl.addHabit(newHabit);
                myHabitList.add(newHabit);
            }
        });

        //the checkboxes for the user to choose days for the habit
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

    //options menu to got to list of habits
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    //goes to habit list
    public void completeHabit(MenuItem menu) {
        Intent intent = new Intent(HabitActivity.this, AddHabitActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        saveInFile();

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        for (Habit habit: hl.getHabitList()) {
            hl.deleteHabit(habit);
        }
        for (Habit habit : myHabitList) {
                hl.addHabit(habit);
        }

    }


    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(hl.getHabitList(), writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22,2016
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            myHabitList = gson.fromJson(in, listType);
            deleteFile(FILENAME);
        } catch (FileNotFoundException e) {
            myHabitList = new ArrayList<Habit>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }


}

