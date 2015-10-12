package com.example.recepinanc.whenfreedeneme;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by recepinanc on 11/10/15.
 */
public class AddWorkActivity extends AppCompatActivity implements AlertDialogFragment.AlertDialogListener {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_DATE = "date";
    public static final String EXTRA_TIME = "time";
    public static final String EXTRA_IS_ADDED = "isAdded";

    private EditText title;
    private RadioGroup categoryRadioGroup;
    private TextView dateSpinner; //use a calendar in an alertdialog
    private TextView timeSpinner; //use a time picker in an alertdialog


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_work_acitivity_layout);

        title = (EditText) findViewById(R.id.todoTitle_editText);
        categoryRadioGroup = (RadioGroup) findViewById(R.id.category_radioGroup);
        dateSpinner = (TextView) findViewById(R.id.dateSpinner_textView);
        timeSpinner = (TextView) findViewById(R.id.timeSpinner_textView);

        dateSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoticeDialog();
            /*
                fm = getFragmentManager();
                datePickerFragment = new DatePickerFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction().add(datePickerFragment, "Add");
                fragmentTransaction.commit();*/
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.cancel_action:
                //TODO Make this return to its activity
                finish();
                break;
            case R.id.save_action:
                //TODO Get info and pass it to the activity's updateArrayMethodString category = "";
                String category = "";
                int checkedRadioID = categoryRadioGroup.getCheckedRadioButtonId();
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
                //passdata via interface
                Intent intent = new Intent(getBaseContext(), WorksActivity.class);
                intent.putExtra(EXTRA_TITLE, title.getText().toString());
                intent.putExtra(EXTRA_CATEGORY, category);
                intent.putExtra(EXTRA_DATE, date);
                intent.putExtra(EXTRA_TIME, time);
                intent.putExtra(EXTRA_IS_ADDED,true);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_activity, menu);
        return true;
    }

    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "AlertDialogFragment");
    }

    /*

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateSpinner.setText(dayOfMonth + " " + monthOfYear + " " + year);
        Toast.makeText(AddWorkActivity.this, dayOfMonth + " " + monthOfYear + " " + year, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void datePasser(int year, int month, int day) {
        dateSpinner.setText(day + " " + month + " " + year);
        Toast.makeText(AddWorkActivity.this, day + " " + month + " " + year, Toast.LENGTH_SHORT).show();
    }
*/

    @Override
    public void noticePositiveClicked(AlertDialogFragment alertDialogFragment) {
        Toast.makeText(AddWorkActivity.this, "On positive button clicked!We're in addworkactivity", Toast.LENGTH_SHORT).show();
    }
}
