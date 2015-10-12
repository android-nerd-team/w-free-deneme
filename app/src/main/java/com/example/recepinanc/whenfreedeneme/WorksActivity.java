package com.example.recepinanc.whenfreedeneme;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by recepinanc on 10/10/15.
 */
public class WorksActivity extends AppCompatActivity {

    private Boolean isAdded = false;
    private ListView todoListView;
    private ArrayList<Work> works;
    private Context mContext;

    //TODO Add school social todo overall buttons.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.works_activity_layout);

        mContext = getApplicationContext();
        works = new ArrayList<Work>();
        /*
        todoListView = (ListView) findViewById(R.id.listView);
        todoListView.setAdapter(new WorkAdapter(getApplicationContext(),works));
        */
    }

    @Override
    protected void onResume() {
        super.onResume();

        isAdded = getIntent().getBooleanExtra(AddWorkActivity.EXTRA_IS_ADDED,false);

        if (isAdded) {
            Work work = new Work(
                    getIntent().getStringExtra(AddWorkActivity.EXTRA_TITLE),
                    getIntent().getStringExtra(AddWorkActivity.EXTRA_CATEGORY),
                    getIntent().getStringExtra(AddWorkActivity.EXTRA_DATE),
                    getIntent().getStringExtra(AddWorkActivity.EXTRA_TIME));

            //works.add(work);
            updateArray(works,work);
            Toast.makeText(WorksActivity.this, "NEWBIE ADDED.", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateArray(ArrayList<Work> works, Work work) {

        //Add a new item add its date and update the array
        works.add(work);
        Toast.makeText(WorksActivity.this, "A new work is created! " +
                "\n" + work.getmName() +
                "\n" + work.getmCategory() +
                "\n" + work.getmDate() +
                "\n" + work.getmTime(), Toast.LENGTH_LONG).show();
    }
    public void updateArray(ArrayList<Work> works, String title,
                            String category,String date, String time,
                            Boolean isDone) {

        //Add a new item add its date and update the array
        works.add(new Work(title,category, date, time));
        Toast.makeText(WorksActivity.this, "A new work is created! " +
                "\n" + title +
                "\n" + date +
                "\n" + time +
                "\n" + isDone.toString() +
                "\n" + category, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_action:
                Intent intent = new Intent(WorksActivity.this,AddWorkActivity.class);
                Log.i("WorksActivity","Created intent");
                startActivity(intent);
                Log.i("WorksActivity", "Started Activity");
            /*
                //TODO Add button will create the fragment that has a save and cancel option on its actionbar
                Toast.makeText(WorksActivity.this, "Add button is Clicked", Toast.LENGTH_SHORT).show();
                LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View v = layoutInflater.inflate(R.layout.alert_dialog_layout, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(WorksActivity.this);
                builder.setTitle("Add New Item")
                        .setView(v)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(WorksActivity.this, "Added!", Toast.LENGTH_SHORT).show();
                                String category = "";
                                EditText input = (EditText) v.findViewById(R.id.todoTitle_editText);
                                RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.category_radioGroup);
                                int checkedRadioID = radioGroup.getCheckedRadioButtonId();
                                switch (checkedRadioID) {
                                    case R.id.todo_radioButton:
                                        category = "todo";
                                        break;
                                    case R.id.school_radioButton:
                                        category = "school";
                                        break;
                                    case R.id.social_radioButton:
                                        category = "social";
                                        break;
                                    default:
                                        Log.e("WorksActivity", "Unexpected RadioButton ID");
                                        break;
                                }
                                DateFormat dateFormat = DateFormat.getDateTimeInstance();
                                String date = dateFormat.format(new Date());
                                String time = ""; //TODO Change this to chosen time
                                updateArray(works, input.getText().toString(),time, date, category);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(WorksActivity.this, "Canceled.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/
                break;
            default:
                Log.e("WorksActivity", "INVALID BUTTON");
                break;
        }

        return true;
    }
}
