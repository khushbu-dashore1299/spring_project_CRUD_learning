package com.learning_crud.Services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning_crud.Models.Todo;
import com.learning_crud.Repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;

	public void createTodo(Todo todolist) {
		todoRepository.save(todolist);
	}

	public List<Todo> readAllTodos() {
		return todoRepository.findAll();
	}

	 public Todo readTodo(int id) {
	        Todo todo = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	        return todo;
	    }

	public void updateTodo(Todo todo, int id) {
		Todo todoToBeUpdated = readTodo(id);
		todoToBeUpdated.setStatus(todo.getStatus());
		todoRepository.save(todoToBeUpdated);
		
	}

	public void deleteTodo(int id) {
		todoRepository.deleteById(id);
		
	}
	
	
	
	

}
