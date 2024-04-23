package com.learning_crud.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.learning_crud.Models.Todo;
import com.learning_crud.Services.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService ;
	
	//localhost:8080/todos
	@PostMapping(path="todos")
	public void  createTodo(@RequestBody Todo todolist) {
		todoService.createTodo(todolist);
	}
	
	@GetMapping(path="todos")
	public List<Todo> readAllTodos(){
		return todoService.readAllTodos();
	}
	
	//   http://localhost:8080/todos/id
	@GetMapping("todos/{id}")
	public Todo readTodo(@PathVariable("id") int id) {
		try {
            return todoService.readTodo(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found", e);
        }
	}
	
	// localhost:8080/todos/id
	@PutMapping("todos/{id}")
	public void updateTodo(@RequestBody Todo todo, @PathVariable("id") int id) {
		try {
			todoService.updateTodo(todo, id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found", e);
		}
	}
	@DeleteMapping("todos/{id}")
	public void deleteTodo(@PathVariable("id") int id) {
		try {
		todoService.deleteTodo(id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found", e);
		}
	}
	

}
