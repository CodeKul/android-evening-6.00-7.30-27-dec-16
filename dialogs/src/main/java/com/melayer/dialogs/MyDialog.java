package com.melayer.dialogs;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE_PICKER="datePicker";
    public static final String TAG_TIME_PICKER = "timePicker";
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_CUSTOM = "customDialog";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals(TAG_ALERT))  dialog = alert();
        else if (getTag().equals(TAG_DATE_PICKER)) dialog = datePicker();
        else if (getTag().equals(TAG_TIME_PICKER)) dialog = timePicker();
        else if(getTag().equals(TAG_PROGRESS)) dialog = progressDialog();
        else dialog = custom();

        return dialog == null ? alert() : dialog;
    }

    @NonNull
    private Dialog custom() {

        final View view = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog,null,false);
        view.findViewById(R.id.edtSearchBox).setOnClickListener(v -> {
            view.findViewById(R.id.progressBar).setVisibility(View.GONE);
            view.findViewById(R.id.listMobiles).setVisibility(View.VISIBLE);
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final AlertDialog dialog = builder.create();
        dialog.setView(view);

        return dialog;
    }

    @NonNull
    private Dialog progressDialog() {

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");

        return progressDialog;
    }

    @NonNull
    private AlertDialog alert() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Okay", (di, which) ->{})
                .setNegativeButton("Cancel", (di, which) ->{});
       return builder.create();
    }

    @NonNull
    private DatePickerDialog datePicker() {
        return new DatePickerDialog(getActivity(), (view, year, month, dayOfMonth) -> mt(dayOfMonth +" - "+(month +1) +" - "+ year), 2017,0,31);
    }

    @NonNull
    private TimePickerDialog timePicker() {
        return new TimePickerDialog(getActivity(), (view, hourOfDay, minute) -> mt(hourOfDay +" : "+ minute), 7,24, false);
    }

    private void mt(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
