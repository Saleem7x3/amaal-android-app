package com.amaal.app.data;

import androidx.room.*;
import java.util.List;

@Dao
public interface DeedDao {

    @Query("SELECT * FROM Deed ORDER BY userOrder ASC")
    List<Deed> getAll();

    @Insert
    void insert(Deed d);

    @Update
    void update(Deed d);
}