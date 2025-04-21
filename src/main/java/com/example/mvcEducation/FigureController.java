package com.example.mvcEducation;

import com.example.DAO.FigureDAO;
import com.example.springEducation.Figure;
import com.example.springEducation.Square;
import com.example.springEducation.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/figures")
public class FigureController {
    private final FigureDAO figureDAO;

    @Autowired
    public FigureController(FigureDAO figureDAO) {
        this.figureDAO = figureDAO;
    }

    @GetMapping()
    public String index(Model model)
    {
        model.addAttribute("figures", figureDAO.index());
        return "figure/index";
    }

    @GetMapping("/{name}")
    public String show(@PathVariable("name") String name, Model model)
    {
        model.addAttribute("figure", figureDAO.show(name));
        return "figure/show";
    }

    @GetMapping("/square")
    public String getSquareForm(Model model)
    {
        model.addAttribute("square", new Square());
        return "square/form";
    }

    @PostMapping("/square")
    public String create(@ModelAttribute("square") Square square)
    {
        figureDAO.save(square);
        return "redirect:/figures";
    }

    @GetMapping("/triangle")
    public String getTriangleForm(Model model)
    {
        model.addAttribute("triangle", new Triangle());
        return "triangle/form";
    }
    @PostMapping("/triangle")
    public String create(@ModelAttribute("triangle")Triangle triangle)
    {
        figureDAO.save(triangle);
        return "redirect:/figures";
    }
}
