package com.example.dictionaryapplication.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String word;

    @ColumnInfo
    private String definition;

    @ColumnInfo
    private String Example;

    @ColumnInfo
    private String synonyms;

    //Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return Example;
    }

    public void setExample(String example) {
        Example = example;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    //Constructor
    public Word(String word, String definition, String example, String synonyms) {
        this.word = word;
        this.definition = definition;
        Example = example;
        this.synonyms = synonyms;
    }

    public Word() {
    }
}
