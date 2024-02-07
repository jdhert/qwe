package com.kitri.springbasicboot.project.todo_list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@Controller
//@RequestMapping("/todo")
public class TodoController1 {
    ArrayList<String> arrayList = new ArrayList<>();
    @GetMapping("")
    public String getView(Model model){
//        if(!arrayList.isEmpty()) {
//            model.addAttribute("arrayList", arrayList);
//        }
        return "project/todo_list/todo";
    }

    @PostMapping("/")
    public String getViews(@RequestParam String todo1){
        arrayList.add(todo1);
        return "redirect:/todo";
    }

}
