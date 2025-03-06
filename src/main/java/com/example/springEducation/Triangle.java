package com.example.springEducation;

public class Triangle implements Figure{
    float sideA, sideB, sideC;

    public float getSideA() {
        return sideA;
    }

    public void setSideA(float sideA) {
        this.sideA = sideA;
    }

    public float getSideB() {
        return sideB;
    }

    public void setSideB(float sideB) {
        this.sideB = sideB;
    }

    public float getSideC() {
        return sideC;
    }

    public void setSideC(float sideC) {
        this.sideC = sideC;
    }

    @Override
    public float getArea() {
        float p = getPerimeter() / 2;
        return (float)Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public float getPerimeter() {
        return sideA + sideB + sideC;
    }

    public void onInit()
    {
        System.out.println("Triangle initialize");
    }

    public void onDestroy()
    {
        System.out.println("Triangle destroy");
    }

    public static Triangle createTriangle(){
        System.out.println("Factory method is called");
        return new Triangle();
    }
}
