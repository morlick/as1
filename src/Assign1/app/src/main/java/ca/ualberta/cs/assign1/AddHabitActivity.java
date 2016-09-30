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
import android.widget.Toast;
import java.util.ArrayList;


public class AddHabitActivity extends Activity {
    private ArrayAdapter<Habit> adapter;
    private ListView oldHabitList;

    private  ArrayList<Habit> myHabitList = new ArrayList();

    private HabitList hl = new HabitList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_activity);

        oldHabitList = (ListView) findViewById( R.id.oldHabitsList);
    }
/*
    oldHabitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

        }
    });

*/

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

        oldHabitList.setAdapter(adapter);
        myHabitList = hl.getHabitList();
        adapter.addAll(myHabitList);

        //adapter.notifyDataSetChanged();
    }

}
