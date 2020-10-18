package com.example.dictionaryapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.dictionaryapplication.Model.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insertWord(Word word);

    @Delete
    void deleteWord(Word word);

    @Update
    void updateWord(Word word);

    @Query("SELECT * FROM Word")
    List<Word> getWords();

    @Query("SELECT * FROM Word WHERE id LIKE :getId")
    Word getWord(int getId);
}
