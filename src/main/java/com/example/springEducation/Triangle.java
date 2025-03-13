package com.example.springEducation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Triangle implements Figure{

    @Value("${triangleBean.sideA}")
    private float sideA;
    @Value("${triangleBean.sideB}")
    private float sideB;
    @Value("${triangleBean.sideC}")
    private float sideC;

    public Triangle()
    {
    }

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

    @PostConstruct
    public void onInit()
    {
        System.out.println("Triangle initialize");
    }

    @PreDestroy
    public void onDestroy()
    {
        System.out.println("Triangle destroy");
    }

    public static Triangle createTriangle(){
        System.out.println("Factory method is called");
        return new Triangle();
    }
}
