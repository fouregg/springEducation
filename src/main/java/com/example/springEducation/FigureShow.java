package com.example.springEducation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class FigureShow {

    private Figure figure;
    private String name;

    //IoC
    /*
    public FigureShow(Figure figure)
    {
        this.figure = figure;
    }
    */
    public FigureShow()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Figure getFigure() {
        return figure;
    }

    @Autowired
    public void setFigure(@Qualifier("triangle") Figure figure) {
        this.figure = figure;
    }

    public void show()
    {
        System.out.println("Perimeter: " + figure.getPerimeter() + "\n" + "Area: " + figure.getArea());
    }

    @Override
    public String toString() {
        return "FigureShow { name: " + this.name + " figure: " + figure.getClass().getName() + " }";
    }
}
