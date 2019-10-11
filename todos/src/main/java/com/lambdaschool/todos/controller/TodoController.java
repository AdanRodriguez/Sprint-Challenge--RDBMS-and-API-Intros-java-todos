package com.lambdaschool.todos.controller;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    //    {
    //        "completed": true
    //    }

    @PutMapping(value = "/todos/todoid/{todoid}",
                produces = {"application/json"},
                consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updatedTodo, @PathVariable long todoid)
    {
        todoService.update(updatedTodo, todoid);
        return new ResponseEntity<>("UPDATE SUCCESS", HttpStatus.OK);
    }

}