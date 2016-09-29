/*
Habit Tracker: User can add and complete habits.

Copyright (C) 2016 Margaret orlick

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



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class HabitActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ArrayList<Habit> habitList = new ArrayList<Habit>();
    private ArrayAdapter<HabitList> adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit_activity);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    public void completeHabit(MenuItem menu) {
        Toast.makeText(this,"complete habit" , Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent(HabitActivity.this, AddHabitActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }
//THIS IS AN ISSUE
    public void addHabitAction(View v) {
      //  Toast.makeText(this, "Adding a student!", Toast.LENGTH_SHORT).show();
     //   HabitListController hlc = new HabitListController();
     //  EditText textView = (EditText) findViewById(R.id.body);
      //  hlc.addHabit(new Habit(textView.getText().toString()));
    }


}
