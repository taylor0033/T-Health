package com.sau.comsci;


public class Exercise {

    private int eid;
    private String ename;
    private String ecalorie;

    public Exercise(){

    }

    public Exercise(String ename, String ecalorie){
        super();
        this.ename = ename;
        this.ecalorie = ecalorie;
    }

    public int getEid(){
        return eid;
    }

    public void setEid(int eid){
        this.eid = eid;
    }


    public String getEname(){
        return ename;
    }


    public void setEname(String ename){
        this.ename = ename;
    }

    public String getEcalorie(){
        return ecalorie;
    }


    public void setEcalorie(String ecalorie){
        this.ecalorie = ecalorie;
    }
}

