package ca.ualberta.cs.assign1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This activity deals with the list of added habits.
A User can view the habits and delete habits.
 */
public class AddHabitActivity extends Activity {
    private ArrayAdapter<Habit> adapter;
    private ListView oldHabitList;
    private String FILENAME = "file.json";

    private  ArrayList<Habit> myHabitList = new ArrayList();

    private HabitList hl = new HabitList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_activity);


        oldHabitList = (ListView) findViewById( R.id.oldHabitsList);

        // When a user clicks on a list item, they do to a page of the history of that habit
        oldHabitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //goes to habit record
                Intent intent = new Intent(AddHabitActivity.this, CompleteActivity.class);
                intent.putExtra("name", position);
                startActivity(intent);
            }
        });

        // When a user presses and hold on a habit, they are prompted to delete the habit.
        oldHabitList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int position, long id) {

                //prompts to delete habit
                AlertDialog.Builder adb = new AlertDialog.Builder(AddHabitActivity.this);
                adb.setMessage("Delete " + myHabitList.get(position).getName() + "?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    //delete button click
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Habit habit = myHabitList.get(finalPosition);
                        myHabitList.remove(habit);
                        hl.deleteHabit(habit);

                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    //cancel button click
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
        saveInFile();
    }

    // in the menu the user can return to the add habit screen
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return true;
    }

    //returns to ad habit activity
    public void goToAddHabit(MenuItem menu) {
        Intent intent = new Intent(AddHabitActivity.this, HabitActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myHabitList = null;
        loadFromFile();


        //simple adapter code adapted from code at
        //http://stackoverflow.com/questions/7920558/android-date-format-inside-listview

        // this creates a simple adapter and adds the habits to it
        //the list view shows the habit and the date is was created on

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (Habit habit: hl.getHabitList()) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("name", habit.getName());

            String dateStr = habit.getDate().toString();
            SimpleDateFormat curFormater = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            Date dateObj = habit.getDate();
            try {
                dateObj = curFormater.parse(dateStr);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            SimpleDateFormat postFormater = new SimpleDateFormat("EEEE, MMMM dd, yyyy");

            String newDateStr = postFormater.format(dateObj);

            datum.put("date", newDateStr);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"name", "date"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});

        //myHabitList = hl.getHabitList();
        oldHabitList.setAdapter(adapter);
        //oldHabitList.setOnItemClickListener(this);

        //oldHabitList.setSelection(0);

    }

    private void loadFromFile() {
        ArrayList<String> tweets = new ArrayList<String>();
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

    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(myHabitList, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }


}
