package com.azure.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.model.TodoItem;
import com.azure.repository.TodoItemRepository;


@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	private TodoItemRepository todoItemRepository;
	
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(todoItemRepository.findAll(), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{index}")
	public ResponseEntity<?> findByIndex(@PathVariable("index") String index){
		try {
			return new ResponseEntity<TodoItem>(todoItemRepository.findById(index).get(), HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<String>(index + " not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> saveTodoItem(@RequestBody TodoItem todoItem){
		try {
			todoItem.setId(UUID.randomUUID().toString());
			todoItemRepository.save(todoItem);
			return new ResponseEntity<String>("TODO Item created", HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<String>("Todo Item not saved", HttpStatus.CONFLICT);
		}	
	}
	
	@PutMapping
	public ResponseEntity<String> updateTodoItem(@RequestBody TodoItem todoItem){
		try {
			todoItemRepository.save(todoItem);
			return new ResponseEntity<String>("TODO ITEM updated", HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("TODO ITEM not updated", HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/{index}")
	public ResponseEntity<String> deleteTodoItem(@PathVariable("index") String index){
		try {
			todoItemRepository.deleteById(index);
			return new ResponseEntity<String>("TODO ITEM deleted", HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<String>("TODOItem not deleted", HttpStatus.NOT_MODIFIED);
		}
	}
}
