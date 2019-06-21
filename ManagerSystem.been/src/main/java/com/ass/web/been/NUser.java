package com.ass.web.been;

public class NUser {
    private String userName;
    private String userKey;
    private boolean gender;
    private String email;
    private  String birthday;
    private String hobby;
    private String selfIntro;

    public NUser() {
    }

    public NUser(String userName, String userKey, boolean gender, String email, String birthday, String hobby, String selfIntro) {
        this.userName = userName;
        this.userKey = userKey;
        this.gender = gender;
        this.email = email;
        this.birthday = birthday;
        this.hobby = hobby;
        this.selfIntro = selfIntro;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }
    public String toString(){
        String s=null;
        s=this.userName+"{"+this.birthday+"-"+this.email+"-"+this.userKey
                +"-"+this.gender
                +"-"+this.hobby
                +"-"+this.selfIntro
              +"}";
        return s;
    }
}
