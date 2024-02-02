package com.kitri.springbasicboot.project.todo_list;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    static HashMap<Integer, Todo> todos = new HashMap<>() ;
    static int id = 6;

    static {
        todos.put(1, new Todo(1, "팔굽혀펴기 100개", false));
        todos.put(2, new Todo(2, "영화 1편 시청", false));
        todos.put(3, new Todo(3, "마트에서 장보기", true));
        todos.put(4, new Todo(4, "명상 2시간", false));
        todos.put(5, new Todo(5, "등산하기", false));
    }
    @GetMapping
    public ArrayList<Todo> todos() {
        return new ArrayList<>(todos.values());
    }
    @PostMapping
    public void add(@RequestBody Todo todo) {
        todo.setId(id);
        todos.put(id++, todo);
//        return todos.put(id++, todo) != null ? true : false;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        todos.remove(id);
    }

    @PutMapping
    public void put(@RequestBody Todo todo){
        todos.put(todo.getId(),todo);
    }


}
