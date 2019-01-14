package com.company;

public class demoArrayListFile {
    private String NameRead;
    private int ScoreRead;

    public demoArrayListFile(String nameRead, int scoreRead) {
        this.NameRead = nameRead;
        this.ScoreRead = scoreRead;
    }

    public String getNameRead() {
        return NameRead;
    }

    public void setNameRead(String nameRead) {
        NameRead = nameRead;
    }

    public int getScoreRead() {
        return ScoreRead;
    }

    public void setScoreRead(int scoreRead) {
        ScoreRead = scoreRead;
    }

    public String toString() {
        return NameRead + " " + ScoreRead;
    }
}
