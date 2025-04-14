package com.example.mvcEducation;

import ch.qos.logback.core.joran.spi.HttpUtil;
import com.example.springEducation.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {
    @Autowired
    Triangle triangle;

    //@RequestMapping(path = "/getTriangleInfo", method = RequestMethod.GET)
    @GetMapping("/getTriangleInfo")
    public String showForm(Model model)
    {
        model.addAttribute("area", triangle.getArea());
        model.addAttribute("perimeter", triangle.getPerimeter());
        return "simple";
    }
    @GetMapping("/sumNumbers")
    public String sumNumbers(
            Model model,
            @RequestParam("num1") String num1,
            @RequestParam("num2") String num2
    )
    {
        int num_1 = Integer.valueOf(num1);
        int num_2 = Integer.valueOf(num2);
        int sum = num_1 + num_2;

        model.addAttribute("num_1", num_1);
        model.addAttribute("num_2", num_2);
        model.addAttribute("sum", sum);

        return "sum";
    }
}
