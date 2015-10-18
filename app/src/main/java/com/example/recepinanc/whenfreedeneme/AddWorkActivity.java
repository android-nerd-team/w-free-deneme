package com.example.recepinanc.whenfreedeneme;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by recepinanc on 11/10/15.
 */
public class AddWorkActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_YEAR = "year";
    public static final String EXTRA_MONTH = "month";
    public static final String EXTRA_DAY = "day";
    public static final String EXTRA_HOUR = "hour";
    public static final String EXTRA_MINUTE = "minute";
    public static final String EXTRA_IS_ADDED = "isAdded";

    static final int DATE_DIALOG_ID = 999;
    static final int TIME_DIALOG_ID = 111;

    private EditText title;
    private RadioGroup categoryRadioGroup;
    private TextView datePicker;
    private TextView timePicker;

    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;
    private boolean is24HourView = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_work_acitivity_layout);

        title = (EditText) findViewById(R.id.todoTitle_editText);
        categoryRadioGroup = (RadioGroup) findViewById(R.id.category_radioGroup);
        datePicker = (TextView) findViewById(R.id.dateSpinner_textView);
        timePicker = (TextView) findViewById(R.id.timeSpinner_textView);

        setDateOnView();

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo call the create dialog method here.
                showDialog(DATE_DIALOG_ID);
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo call create dialog for time picker.
                showDialog(TIME_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                //set date as the current date
                return new DatePickerDialog(this, dateSetListener, year, month, day);
            case TIME_DIALOG_ID:
                //set time as the current time
                return new TimePickerDialog(this, timeSetListener, hour, minute, is24HourView);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {

            //assign selected values
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            //update the textView to selected date
            setDateAsText(datePicker);
        }

    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {

            //assign the selected time
            hour = selectedHour;
            minute = selectedMinute;

            setTimeAsText(timePicker);
        }
    };

    private void setDateOnView() {

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        setDateAsText(datePicker);
        setTimeAsText(timePicker);

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
                //pass data via intent
                Intent intent = new Intent(getBaseContext(), WorksActivity.class);
                intent.putExtra(EXTRA_TITLE, title.getText().toString());
                intent.putExtra(EXTRA_CATEGORY, category);
                intent.putExtra(EXTRA_HOUR, hour);
                intent.putExtra(EXTRA_MINUTE, minute);
                intent.putExtra(EXTRA_YEAR, year);
                intent.putExtra(EXTRA_MONTH, month);
                intent.putExtra(EXTRA_DAY, day);
                intent.putExtra(EXTRA_IS_ADDED, true);
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

    public String monthConverter(int month) {
        switch (month + 1) {
            case 1:
                return "JANUARY";
            case 2:
                return "FEBRUARY";
            case 3:
                return "MARCH";
            case 4:
                return "APRIL";
            case 5:
                return "MAYY";
            case 6:
                return "JUNE";
            case 7:
                return "JULY";
            case 8:
                return "AUGUST";
            case 9:
                return "SEPTEMBER";
            case 10:
                return "OCTOBER";
            case 11:
                return "NOVEMBER";
            case 12:
                return "DECEMBER";
            default:
                return "UNKNOWN";
        }
    }

    public String minuteConverter(int minute) {
        if (minute / 10 <= 0)
            return "0" + minute;
        else
            return minute + "";
    }

    public void setDateAsText(TextView datePicker) {
        datePicker.setText(new StringBuilder().append(day).append(" ")
                .append(monthConverter(month)).append(" ").append(year));
    }

    public void setTimeAsText(TextView timePicker) {
        timePicker.setText(new StringBuilder().append(hour).append(":").append(minuteConverter(minute)));
    }
}
