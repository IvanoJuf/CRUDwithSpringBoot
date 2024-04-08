package com.project.crud.recursos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity //Esta clase es una entidad en mi DB
@Table //Y es una tabla
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "usuario_rol",joinColumns = @JoinColumn(name = "user_id",referencedColumnName ="id"),
			inverseJoinColumns= @JoinColumn(name = "rol_id",referencedColumnName="id"))
	private Set<Rol> idRoles = new HashSet<>();
	 
	//Constructor vacío
	public Usuario() {
		
	}

	//Constructor cargado
	public Usuario(int id, String nombre, String aPaterno, String aMaterno) {
		this.id = id;
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
	}

	//Constructor sin id - para cargar dato a tabla ya que el id se genera en automatico
	public Usuario(String nombre, String aPaterno, String aMaterno) {
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
	}

	public Set<Rol> getRoles() {
        return idRoles;
    }
	
	//Generamos Getters y setters
	
	
	
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

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public Set<Rol> getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(Set<Rol> idRoles) {
		this.idRoles = idRoles;
	}
	
	

	//Regreso a CrudApplication
	
	
	

}
