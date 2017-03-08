package com.sau.comsci;

public class Profile {
    private int id;
    private String name;
    private int age;
    private int weight;
    private int height;
    private String sex;

    public Profile(int id, String name, int age, int weight, int height, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
    }

    public int getId() {return this.id;}

    public String getName() {
        return this.name;
    }

    public int getAge() {return this.age;}

    public int getWeight() {
        return this.weight;
    }

    public int getHeight() {
        return this.height;
    }

    public String getSex() {return this.sex;}
}
