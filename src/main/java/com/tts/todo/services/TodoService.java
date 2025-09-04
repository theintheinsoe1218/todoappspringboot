package com.tts.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tts.todo.models.Todo;
import com.tts.todo.repositories.TodoRepo;

@Service
public class TodoService {
    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> all() {
        List<Todo> todos = todoRepo.findAll();
        return todos;
    }

    public void add(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        todoRepo.save(todo);
    }

    public Todo get(Long id) {
        Todo todo = todoRepo.findById(id).orElse(null);
        return todo;
    }

    public void modify(Long id, String title) {
        Todo todo = todoRepo.findById(id).orElse(null);
        if (todo != null) {
            todo.setTitle(title);
            todoRepo.save(todo);
        }
    }

    public void toggle(Long id) {
        Todo todo = todoRepo.findById(id).orElse(null);
        if (todo != null) {
            todo.setCompleted(!todo.isCompleted());
            todoRepo.save(todo);
        }
    }

    public void delete(Long id) {
        todoRepo.deleteById(id);
    }

    public List<Todo> filter(boolean completed) {
        List<Todo> tds = new ArrayList<>();
        List<Todo> todos = todoRepo.findAll();

        for (Todo todo : todos) {
            if (todo.isCompleted() == completed) {
                tds.add(todo);
            }
        }
        return tds;
    }
}
