package com.tts.todo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.todo.models.Todo;
import com.tts.todo.services.TodoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public String all(Model model) {
        List<Todo> todos = todoService.all();
        model.addAttribute("todos", todos);
        return "todos/all";
    }

    @GetMapping("add")
    public String add() {
        return "todos/add";
    }

    @PostMapping("add")
    public String create(@RequestParam String title) {
        todoService.add(title);
        return "redirect:/todos";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id) {
        return "todos/edit";
    }

    @PostMapping("edit/{id}")
    public String update(@PathVariable Long id) {
        return "redirect:/todos";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        return "redirect:/todos";
    }

}
