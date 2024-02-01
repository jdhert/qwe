package com.kitri.springbasicboot.lesson.mapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // 리턴이 view 주소임
public class MappingController {
    // view 이름
    @GetMapping("/get")
    @ResponseBody //응답값을 바디에 넣어서 보내겠다
    public String get(){
        return "hello";
    }

    @GetMapping("/get2")
    public String get2(Model model){
        model.addAttribute("message", "Stanley Kubrick");
        return "lesson/mapping";
    }

    @GetMapping("/get3")
    public String get3(HttpServletRequest request){
        request.setAttribute("message", "crème de la crème");
        return "lesson/mapping";
    }

    @RequestMapping(value = {"/a","/b", "/c"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String multiURL(Model model){
        model.addAttribute("message", "ce qu'il y a de meilleur");
        return "lesson/mapping";
    }

    @PostMapping("/post")
    public String post(Model model){
        model.addAttribute("message", "Post Malone");
        return  "lesson/mapping";
    }

    @RequestMapping (value = "/put", method = {RequestMethod.GET, RequestMethod.PUT})
    public ModelAndView put(ModelAndView modelAndView){
        modelAndView.setViewName("lesson/mapping");
        modelAndView.addObject("message", "Pusha T");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public String delete(Model model){
        model.addAttribute("message", "Delegation");
        return "lesson/mapping";
    }
}
