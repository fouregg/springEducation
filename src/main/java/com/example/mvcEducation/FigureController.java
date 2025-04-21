package com.example.mvcEducation;

import com.example.DAO.FigureDAO;
import com.example.springEducation.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Figure test = figureDAO.show(name);
        System.out.println(test.getName());
        model.addAttribute("figure", test);
        return "figure/show";
    }
}
