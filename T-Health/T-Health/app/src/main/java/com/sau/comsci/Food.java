package com.sau.comsci;


public class Food {
    private int fid;
    private String fname;
    private String fcalorie;

    public Food(){

    }

    public Food(String fname, String fcalorie){
        super();
        this.fname = fname;
        this.fcalorie = fcalorie;
    }

    public int getFid(){
        return fid;
    }

    public void setFid(int fid){
        this.fid = fid;
    }


    public String getFname(){
        return fname;
    }


    public void setFname(String fname){
        this.fname = fname;
    }

    public String getFcalorie(){
        return fcalorie;
    }


    public void setFcalorie(String fcalorie){
        this.fcalorie = fcalorie;
    }
}
