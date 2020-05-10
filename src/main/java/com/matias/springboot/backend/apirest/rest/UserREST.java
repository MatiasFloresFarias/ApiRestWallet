package com.matias.springboot.backend.apirest.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.springboot.backend.apirest.DAO.UsersDAO;
import com.matias.springboot.backend.apirest.entity.User;

@RestController
@RequestMapping("users")
public class UserREST {
	@Autowired
	private UsersDAO userDAO;
	
//Metodo mostrar todos los usuarios 
	@GetMapping
	public ResponseEntity<List<User>> getUser(){
		List<User> users = userDAO.findAll();
			return ResponseEntity.ok(users); 			
		}	
//metodo Mostrar usuario por ID 
	@RequestMapping(value="{userId}")
	public ResponseEntity<User>getUserByID(@PathVariable("userId") Integer userId){
		Optional<User> optionalUser= userDAO.findById(userId);
		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
			
		}else {	
		
			return ResponseEntity.noContent().build();
		}	
				
	}
//metodo crear usuario  
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User newUser = userDAO.save(user); 
		return ResponseEntity.ok(newUser);	
		
	}
//metodo borrar usuario  
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Void>deleteUser(@PathVariable("userId") Integer userId){
		userDAO.deleteById(userId);
		return ResponseEntity.ok(null);
		
	}
//metodo modificar usuario 
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		Optional<User> optionalUser = userDAO.findById(user.getId());
		if (optionalUser.isPresent()) {
			User updateUser = optionalUser.get();
			updateUser.setNombre(user.getNombre());
			updateUser.setApellido(user.getApellido());
			updateUser.setCorreo(user.getCorreo());
			updateUser.setContraseña(user.getContraseña());
			userDAO.save(updateUser);

			return ResponseEntity.ok(updateUser);

		} else {

			return ResponseEntity.notFound().build();
		}

	}

}
