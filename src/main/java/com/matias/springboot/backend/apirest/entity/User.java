package com.matias.springboot.backend.apirest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Señalamos que es una entidad  y que la designamos a la tabla de un base de datos  
@Entity
@Table(name="users")
public class User {	
	//variables de la clase Cliente  
	
	//mencionamos que es un id, y que esta en la columna id de la DB y generamos una id AutoIncremental
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name="apellido", nullable = false, length = 50)
	private String apellido;
	
	@Column(name="correo", nullable = false, length = 30)
	private String Correo;
	
	@Column(name="contraseña", nullable = false, length = 10)
	private String contraseña;
	

	// get and set 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
	
	

}
