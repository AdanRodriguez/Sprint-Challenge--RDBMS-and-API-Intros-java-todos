package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;

import java.util.List;

public interface TodoService
{
    Todo updateTodo(Todo todo, long todoid);

    List<Todo> findAllTodos();

    Todo findtodoById(long id);

    Todo findtodoByName(String name);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);
}