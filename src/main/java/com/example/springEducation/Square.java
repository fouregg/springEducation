package com.example.springEducation;

import org.springframework.stereotype.Component;


public class Square implements Figure{
    @Override
    public float getArea() {
        return 5 * 5;
    }

    @Override
    public float getPerimeter() {
        return 4 * 5;
    }
}
