package com.example.quesapp;

public class QuestionObject {
    String id;
    public String question, answer, option1, option2, option3;
    public QuestionObject(String id, String qn, String ans, String op1, String op2, String op3){
        this.id=id;
        this.question=qn;
        this.answer=ans;
        this.option1=op1;
        this.option2=op2;
        this.option3=op3;
    }

    public QuestionObject() {
        // TODO Auto-generated constructor stub
    }

    public String getId(){
        return this.id;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }

    public String getOption1(){
        return this.option1;
    }

    public String getOption2(){
        return this.option2;
    }

    public String getOption3(){
        return this.option3;
    }
}
