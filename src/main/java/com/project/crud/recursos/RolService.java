package com.project.crud.recursos;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolService {
	
	//Inyección de dependencias
	private final CrudRol crudRol;
	HashMap<String,Object> datos = new HashMap<>();
	
	//Inyección de dependencias - Ahora puedo usar los métodos de la clase CrudRol
	@Autowired
	public RolService(CrudRol crudRol) {
		this.crudRol = crudRol;
	}
	
	public List<Rol> getRoles() {
		//return List.of(new Rol (1,"Gerente"));
		return this.crudRol.findAll(); //CrudRol extiende de JpaRepository que contiene métodos para realizar consultas a DB.
	}
	
	public void nuevoRol(Rol rol) {
		Optional<Rol> res = crudRol.findRolByNombre(rol.getNombre());
		
		if(res.isPresent()) {
			throw new IllegalStateException("El usuario ya existe");
		}
		crudRol.save(rol);
	}
	
	public ResponseEntity<Object> deleteRol(int id) {
		boolean existe = this.crudRol.existsById(id);
		
		if(!existe) {
			datos.put("error", true);
			datos.put("message", "El Rol no existe");
			return new ResponseEntity<>(datos,HttpStatus.CONFLICT);
		}
		crudRol.deleteById(id);
		datos.put("message", "Rol Eliminado");
		return new ResponseEntity<>(datos,HttpStatus.ACCEPTED);
	}

}
