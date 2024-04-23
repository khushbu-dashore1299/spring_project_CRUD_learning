package com.learning_crud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning_crud.Models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

}
