package com.amaal.app.data;

import android.content.Context;
import androidx.room.*;

@Database(entities = {Deed.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract DeedDao deedDao();

    public static AppDatabase get(Context c) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                c.getApplicationContext(),
                AppDatabase.class,
                "amaal.db"
            ).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}