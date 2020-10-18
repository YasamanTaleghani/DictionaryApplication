package com.example.dictionaryapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.dictionaryapplication.Controller.Model.Word;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao mWordDao();
}
