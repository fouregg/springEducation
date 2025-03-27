package com.example.mvcEducation;

import com.example.springEducation.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Autowired
    Triangle triangle;

    @GetMapping("/simple")
    public String showForm(Model model)
    {
        model.addAttribute("area", triangle.getArea());
        model.addAttribute("perimeter", triangle.getPerimeter());
        return "simple";
    }
}
