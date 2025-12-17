package com.amaal.app.ui;

import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import com.amaal.app.R;
import com.amaal.app.data.*;

public class PrayerConfigDialog {

    public static void show(Context c, Deed d, AppDatabase db) {
        View v = LayoutInflater.from(c)
            .inflate(R.layout.dialog_prayer_config, null);

        TimePicker t = v.findViewById(R.id.timePicker);
        NumberPicker n = v.findViewById(R.id.windowPicker);

        n.setMinValue(5);
        n.setMaxValue(60);
        n.setValue(d.priorityWindowMinutes);

        new AlertDialog.Builder(c)
            .setTitle("Jamāʿah Settings")
            .setView(v)
            .setPositiveButton("Save", (x,y) -> {
                d.jamaahHour = t.getHour();
                d.jamaahMinute = t.getMinute();
                d.priorityWindowMinutes = n.getValue();
                db.deedDao().update(d);
            })
            .show();
    }
}