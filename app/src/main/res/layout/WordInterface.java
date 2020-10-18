package com.example.dictionaryapplication.Repository;
import java.util.List;

public interface WordInterface extends WordDao {
    List<Word> getWords();
    Word getWord(int id);
    boolean searchWord(Word word);
    void insertWord(Word word);
    void deleteWord(Word word);
    void updateWord(Word word);
}
