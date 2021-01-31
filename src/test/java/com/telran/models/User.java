package com.telran.models;

public class User {
    private String fName;
    private String lName;
    private String uName;
    private String password;

    public User withFname(String fNameame) {
        this.fName = fName;
        return this;
    }

    public User withlName(String lName) {
        this.lName = lName;
        return this;
    }

    public User withuName(String uName) {
        this.uName = uName;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getuName() {
        return uName;
    }

    public String getPassword() {
        return password;
    }


}
