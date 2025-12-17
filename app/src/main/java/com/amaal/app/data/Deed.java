package com.amaal.app.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Deed {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String category;
    public boolean completedToday;

    public boolean isPrayer;
    public boolean usesJamaah;

    public int jamaahHour;
    public int jamaahMinute;
    public int priorityWindowMinutes;

    public int estimatedMinutes;
    public int userOrder;
}