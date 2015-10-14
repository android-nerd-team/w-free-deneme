package com.example.recepinanc.whenfreedeneme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by recepinanc on 12/10/15.
 */
public class AlertDialogFragment extends DialogFragment {

    AlertDialogListener alertDialogListener;

    int year,month,day;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            alertDialogListener = (AlertDialogListener) getActivity();
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + " must implement the AlertDialogInterface"
            );
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v;
        v = layoutInflater.inflate(R.layout.alert_dialog_layout,null);

        Calendar calendar = Calendar.getInstance();
        long currentDate = calendar.getTimeInMillis();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePicker dpicker = (DatePicker) v.findViewById(R.id.datePicker);
        dpicker.setCalendarViewShown(true);
        dpicker.init(year, month, day, null);

        builder.setView(v)
                .setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialogListener.noticePositiveClicked(AlertDialogFragment.this);
                    }
                });
        return builder.create();
    }

    public interface AlertDialogListener{
        void noticePositiveClicked(AlertDialogFragment alertDialogFragment);
    }
}
