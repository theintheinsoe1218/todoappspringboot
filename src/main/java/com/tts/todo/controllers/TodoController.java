package com.tts.todo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.todo.models.Todo;
import com.tts.todo.pojos.TodoPojo;
import com.tts.todo.services.TodoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String create(@ModelAttribute TodoPojo todoPojo) {
        todoService.add(todoPojo.getTitle());
        return "redirect:/todos";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Todo todo = todoService.get(id);
        model.addAttribute("todo", todo);
        return "todos/edit";
    }

    @PostMapping("edit/{id}")
    public String update(@PathVariable Long id, @RequestParam String title) {
        todoService.modify(id, title);
        return "redirect:/todos";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/todos";
    }

    @GetMapping("toggle/{id}")
    public String toggle(@PathVariable Long id) {
        todoService.toggle(id);
        return "redirect:/todos";
    }

    @GetMapping("filter/{completed}")
    public String getMethodName(@PathVariable boolean completed, Model model) {
        List<Todo> todos = todoService.filter(completed);
        model.addAttribute("todos", todos);
        return "todos/all";
    }

}
