package com.example.junaedmohammed.wordexplorer;

/**
 * Created by Junaed Mohammed on 03-Feb-18.
 */

public class WordModel {

    private int id;
    private String word;
    private String meaning;
    private String synonym;
    private String antonym;
    private String example;

    public WordModel(String w){

        word =w;
    }

    public WordModel(int id, String word, String meaning, String synonym, String antonym, String example) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.synonym = synonym;
        this.antonym = antonym;
        this.example = example;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public void setAntonym(String antonym) {
        this.antonym = antonym;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getSynonym() {
        return synonym;
    }

    public String getAntonym() {
        return antonym;
    }

    public String getExample() {
        return example;
    }
}
