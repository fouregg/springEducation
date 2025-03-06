package com.example.springEducation;

public class FigureShow {
    private Figure figure;
    private String name;

    //IoC
    public FigureShow(Figure figure)
    {
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
