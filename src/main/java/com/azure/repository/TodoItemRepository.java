package com.azure.repository;

import org.springframework.stereotype.Repository;

import com.azure.model.TodoItem;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

@Repository
public interface TodoItemRepository extends DocumentDbRepository<TodoItem, String>{

}
