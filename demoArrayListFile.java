package com.company;

public class demoArrayListFile {
    private String nameRead;
    private int scoreRead;

    public demoArrayListFile(String nameReadFile, int scoreReadFile) {
        this.nameRead = nameReadFile;
        this.scoreRead = scoreReadFile;
    }

    public String getNameRead() {
        return nameRead;
    }

    public void setNameRead(String nameReadFile) {
        nameRead = nameReadFile;
    }

    public int getScoreRead() {
        return scoreRead;
    }

    public void setScoreRead(int scoreReadFile) {
        scoreRead = scoreReadFile;
    }

    public String toStringSecond() {
        return nameRead + " " + scoreRead;
    }
}
