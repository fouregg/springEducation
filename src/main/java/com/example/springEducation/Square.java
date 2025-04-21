package com.example.springEducation;

import org.springframework.stereotype.Component;


public class Square extends Figure{
    private int sideA, sideB;

    public Square(String name, int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.name = name;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    @Override
    public float getArea() {
        return 5 * 5;
    }

    @Override
    public float getPerimeter() {
        return 4 * 5;
    }
}
