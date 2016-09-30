package ca.ualberta.cs.assign1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class AddHabitActivity extends Activity {
    private ArrayAdapter<Habit> adapter;
    private static ArrayList<Habit> myHabitList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HabitList hl = new HabitList();
        HabitListController st = new HabitListController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_activity);
        myHabitList = (ArrayList) hl.getHabitList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return true;
    }

    public void goToAddHabit(MenuItem menu) {
        Toast.makeText(this,"complete habit" , Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent(AddHabitActivity.this, HabitActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, myHabitList);
        Habit h = new Habit("hello");
        ListView view = (ListView) findViewById( R.id.oldHabitsList );
        view.setAdapter(adapter);


    }

}
