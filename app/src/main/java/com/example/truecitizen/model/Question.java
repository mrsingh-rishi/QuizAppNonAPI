package com.example.truecitizen.model;

public class Question {
    private int ansResId;
    private boolean answerTrue;
    public Question(int answerResId, boolean answerTrue){
        this.ansResId = answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnsResId() {
        return ansResId;
    }

    public void setAnsResId(int ansResId) {
        this.ansResId = ansResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
