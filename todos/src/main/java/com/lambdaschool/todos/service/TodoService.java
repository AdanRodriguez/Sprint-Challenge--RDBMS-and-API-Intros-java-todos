package com.lambdaschool.todos.service;


import com.lambdaschool.todos.model.Todo;

import java.util.List;

public interface TodoService
{
    Todo updateTodo(Todo todo, long todoid);

    List<Todo> findAllTodos();
}