/*
package com.example.recepinanc.whenfreedeneme;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

*/
/**
 * Created by recepinanc on 11/10/15.
 *//*

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public static int mYear,mMonth,mDay;
    private NoticeDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (NoticeDialogListener) activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + "must implement NoticeDialoglistener" +
                    " class");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
        datePickerDialog.BUTTON_POSITIVE
        // Create a new instance of DatePickerDialog and return it
        return
    }



    public void onDateSet(DatePicker view, int year, int month, int day) {
        mYear = year;
        mMonth = month;
        mDay = day;
        Toast.makeText(getActivity().getApplicationContext(), "DATASET ÇALIŞTI", Toast.LENGTH_SHORT).show();
    }

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
}
*/
