package com.lambdaschool.todos.controller;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.model.User;
import com.lambdaschool.todos.service.TodoService;
import com.lambdaschool.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController
{
    @Autowired
    private TodoService todoService;


    // PUT -- http://localhost:2019/todos/todoid/{todoid}
    // Updates a to do
    @PutMapping(value = "/todoid/{todoid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(Authentication authentication,
                                        @RequestBody Todo todo,
                                        @PathVariable long todoid)
    {
        todoService.updateTodo(todo, todoid);
        return new ResponseEntity<>("UPDATE SUCCESS", HttpStatus.OK);
    }


    // GET -- http://localhost:2019/todos/todos
    // get all todos
    @GetMapping(value = "/todos",
                produces = {"application/json"})
    public ResponseEntity<?> getAllTodos()
    {
        return new ResponseEntity<>(todoService.findAllTodos(), HttpStatus.OK);
    }
}