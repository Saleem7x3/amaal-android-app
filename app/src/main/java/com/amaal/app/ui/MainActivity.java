package com.amaal.app.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.amaal.app.R;
import com.amaal.app.data.*;
import com.amaal.app.logic.FocusEngine;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    TextView focusTitle;
    Button markDone;
    Deed currentFocus;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        db = AppDatabase.get(this);

        if (db.deedDao().getAll().isEmpty())
            seedDefaults();

        focusTitle = findViewById(R.id.focusTitle);
        markDone = findViewById(R.id.markDoneBtn);

        RecyclerView rv = findViewById(R.id.deedList);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Deed> deeds = db.deedDao().getAll();
        currentFocus = FocusEngine.selectFocus(deeds);

        if (currentFocus != null)
            focusTitle.setText(currentFocus.title);

        markDone.setOnClickListener(v -> {
            if (currentFocus != null) {
                currentFocus.completedToday = true;
                db.deedDao().update(currentFocus);
                recreate();
            }
        });

        rv.setAdapter(new DeedAdapter(deeds, db));
    }

    private void seedDefaults() {
        String[] prayers = {"Fajr","Dhuhr","Asr","Maghrib","Isha"};
        int i = 0;
        for (String p : prayers) {
            Deed d = new Deed();
            d.title = p + " Prayer";
            d.category = "FARD_AYN";
            d.isPrayer = true;
            d.usesJamaah = true;
            d.priorityWindowMinutes = 15;
            d.estimatedMinutes = 5;
            d.userOrder = i++;
            db.deedDao().insert(d);
        }
    }
}
