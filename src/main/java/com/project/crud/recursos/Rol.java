package com.project.crud.recursos;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int id;
	private String nombre;
	
	@ManyToMany(mappedBy = "idRoles")
	@JsonIgnore //Evita la serialización de usuarios dentro de roles
	private Set<Usuario> usuarios = new HashSet<>();
	
	public Rol( ) {
		
	}

	public Rol(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Rol(String nombre) {
		this.nombre = nombre;
	}

	public int getIdRol() {
		return id;
	}

	public void setIdRol(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
