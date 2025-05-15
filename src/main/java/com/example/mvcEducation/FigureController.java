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

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name)
    {
        Figure tmp = figureDAO.getObject(name);
        if (tmp != null)
            figureDAO.remove(tmp);
        return "redirect:/figures";
    }

    @GetMapping("/update/{name}")
    public String getUpdateForm(@PathVariable("name") String name, Model model)
    {
        Figure tmp = figureDAO.getObject(name);
        if (tmp != null)
        {
            if (tmp instanceof Triangle) {
                model.addAttribute("triangle", tmp);
                return "triangle/updateForm";
            }
            else {
                model.addAttribute("square", tmp);
                return "square/updateForm";
            }
        }
        return "redirect:/figures";
    }

    @PatchMapping("/update/triangle/{name}")
    public String updateTriangle(
            @PathVariable String name,
            @ModelAttribute Triangle figure) {  // Используем конкретный класс
        Figure tmp = figureDAO.getObject(name);
        figureDAO.update(tmp, figure);
        return "redirect:/figures";
    }

    @PatchMapping("/update/square/{name}")
    public String updateSquare(
            @PathVariable String name,
            @ModelAttribute Square figure) {  // Используем конкретный класс
        Figure tmp = figureDAO.getObject(name);
        figureDAO.update(tmp, figure);
        return "redirect:/figures";
    }

}
