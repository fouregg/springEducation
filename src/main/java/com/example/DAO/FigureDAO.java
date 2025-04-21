package com.example.DAO;

import com.example.springEducation.Figure;
import com.example.springEducation.Square;
import com.example.springEducation.Triangle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FigureDAO {
    private static int COUNT_FIGURE;
    public List<Figure> figures;
    public FigureDAO()
    {
        COUNT_FIGURE = 0;
        figures = new ArrayList<>();

        figures.add(new Triangle("testTriangle", 3,4,5));
        COUNT_FIGURE++;
        figures.add(new Square("testSquare", 10, 5));
        COUNT_FIGURE++;
    }


    public List<Figure> index(){
        return figures;
    }

    public Figure show(String name)
    {
        return figures.stream()
                .filter(figure -> figure.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public void save(Figure figure)
    {
        figures.add(figure);
        COUNT_FIGURE++;
    }
}
