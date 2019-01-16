package com.company;

public class DemoArrayList {
    private String name;
    private int score;

    public DemoArrayList(String namemini, int scoremini) {
        name = namemini;
        score = scoremini;
    }

    public String getName() {
        return name;
    }

    public void setName(String namemini) {
        name = namemini;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int scoremini) {
        score = scoremini;
    }

    @Override
    public String toString() {
        return name +" "+ score;
    }
}
