package com.tts.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tts.todo.models.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
