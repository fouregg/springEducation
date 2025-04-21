package com.example.springEducation;

public abstract class Figure {
    protected String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract float getArea();
    public abstract float getPerimeter();
}
