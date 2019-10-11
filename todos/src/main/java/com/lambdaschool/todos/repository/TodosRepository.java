package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface TodosRepository extends CrudRepository<Todo, Long>
{
    @Modifying
    @Query(value = "DELETE FROM todoitems WHERE todoid = :todoid", nativeQuery = true)
    void deleteTodos(long todoid);

    @Query(value = "SELECT u.username as username, COUNT(*) as createtodos FROM t JOIN users u ON t.userid= u.userid GROUP BY u.username ", nativeQuery = true)
    ArrayList<JustTheCount> getCreateTodos();
}

//import com.lambdaschool.todos.models.Todo;
//        import org.springframework.data.repository.CrudRepository;
//
//public interface TodoRepository extends CrudRepository<Todo, Long>
//{
//}