package com.magung.daoroom;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class DataDao {
    @Query("SELECT * FROM Meal")
    public abstract List<Meal> getAll();

    @Insert
    public abstract void insertAll(Meal meal);

    @Update
    public abstract void update(Meal meal);

    @Delete
    public abstract void delete(Meal meal);

}
