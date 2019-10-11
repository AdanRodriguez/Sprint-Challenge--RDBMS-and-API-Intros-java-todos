package com.lambdaschool.todos.service;


import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private TodosRepository todorepos;

    @Transactional
    @Override
    public Todo updateTodo(Todo todo, long todoid)
    {
        Todo currentTodo = todorepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException(Long.toString(todoid)));

        if (todo.getDatestarted() != null)
        {
            currentTodo.setDatestarted(todo.getDatestarted());
        }

        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());
        }

        currentTodo.setCompleted(todo.isCompleted());

        return todorepos.save(currentTodo);
    }

    @Override
    public List<Todo> findAllTodos()
    {
        List<Todo> rtnList = new ArrayList<>();

        todorepos.findAll().iterator().forEachRemaining(rtnList::add);

        return rtnList;
    }
}