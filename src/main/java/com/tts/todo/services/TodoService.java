package com.tts.todo.services;

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
}
