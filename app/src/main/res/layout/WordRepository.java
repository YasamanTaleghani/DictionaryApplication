package com.example.dictionaryapplication.Repository;

import android.content.Context;

import androidx.room.Room;

import com.example.dictionary.Controler.Model.Word;
import com.example.dictionary.Controler.database.WordDao;
import com.example.dictionary.Controler.database.WordDatabase;

import java.util.List;

public class WordRepository implements WordInterface {

    private static WordRepository sInstance;
    private WordDao mWordDao;
    private Context mContext;

    public static WordRepository getInstance(Context context) {
        if (sInstance == null)
            sInstance = new WordRepository(context);

        return sInstance;
    }

    private WordRepository(Context context) {
        mContext = context.getApplicationContext();

         WordDatabase wordDatabase =
                Room.databaseBuilder(mContext, WordDatabase.class,"word.db")
                        .allowMainThreadQueries()
                        .build();

        mWordDao = wordDatabase.mWordDao();
    }

    @Override
    public List<Word> getWords() {
        return mWordDao.getWords();
    }

    @Override
    public Word getWord(int getId) {
        return mWordDao.getWord(getId);
    }

    @Override
    public boolean searchWord(Word word) {
        List<Word> lists = mWordDao.getWords();
        for (int i = 0; i <lists.size() ; i++) {
            Word mWord = lists.get(i);
            if (word.getWord().toLowerCase().equals(mWord.getWord().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void insertWord(Word word) {
        mWordDao.insertWord(word);
    }

    @Override
    public void deleteWord(Word word) {
        mWordDao.deleteWord(word);
    }

    @Override
    public void updateWord(Word word) {
        mWordDao.updateWord(word);
    }
}
