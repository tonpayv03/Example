package com.company;

public class demoArrayList {
    private String Name;
    private int Score;

    public demoArrayList(String name, int score) {
        Name = name;
        Score = score;
    }

    public demoArrayList() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Override
    public String toString() {
        return Name +" "+ Score;
    }
}
