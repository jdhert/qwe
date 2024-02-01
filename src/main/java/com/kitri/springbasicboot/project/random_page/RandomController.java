package com.kitri.springbasicboot.project.random_page;

import com.kitri.springbasicboot.lesson.mapping.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping("/random")
public class RandomController {

    @GetMapping("/color")
    public String show(Model model){
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        int[] color = {r, g, b};
        model.addAttribute("color", color);
        return "project/random_page/page";
    }

    @GetMapping("/number/{n}")
    @ResponseBody
    public int getNum(@PathVariable int n){
        Random random = new Random();
        return random.nextInt((n+1));
    }
}
