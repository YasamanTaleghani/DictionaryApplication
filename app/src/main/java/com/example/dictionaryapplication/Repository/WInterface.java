package com.example.dictionaryapplication.Repository;

import com.example.dictionaryapplication.Model.Word;
import com.example.dictionaryapplication.database.WordDao;

import java.util.List;

public interface WInterface extends WordDao {
    List<Word> getWords();
    Word getWord(int id);
    boolean searchWord(Word word);
    void insertWord(Word word);
    void deleteWord(Word word);
    void updateWord(Word word);
}
