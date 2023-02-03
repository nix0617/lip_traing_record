package com.android.example.lip_traing_record;

public class Record {
    private String word;
    private Integer isCorrect;
    private String date;
    private String time;


    public Record(String word, Integer isCorrect, String date, String time) {
        this.word = word;
        this.isCorrect = isCorrect;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Record{" +
                ", word='" + word + '\'' +
                ", isCorrect=" + isCorrect +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
