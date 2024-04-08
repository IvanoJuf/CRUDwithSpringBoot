package com.project.crud.recursos;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	//Inyección de dependencias
	private final CrudUsuario crudUsuario;
	private final CrudRol crudRol;
	HashMap<String,Object> datos = new HashMap<>();
	
	//Inyección de dependencias - ahora puedo usar los métodos de CrudUsuario
	@Autowired
	public UsuarioService(CrudUsuario crudUsuario,CrudRol crudRol) {
		this.crudUsuario = crudUsuario;
		this.crudRol = crudRol;
	}
	
	public List<Usuario> getUsuarios() {
		//return List.of (new Usuario(1,"Ivan","Juarez","Flores")); //Datos que deben provenir de DB
		
		return this.crudUsuario.findAll(); //CrudUsuario extiende de JpaRepository que contieme métodos para hacer consultas a DB.
	}

	public void nuevoUsuario(Usuario usuario,int idRol) {
		Optional<Usuario> res = crudUsuario.findUsuarioByNombre(usuario.getNombre());
		
		//if(res.isPresent()) {
			//throw new IllegalStateException("El usuario ya existe");
		//}

		Rol rol = crudRol.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado")); 

		// Asignar el rol al usuario
		//usuario.setIdRoles(rol);
		usuario.getIdRoles().add(rol);
	    //Guardar el usuario
   		crudUsuario.save(usuario);

	}
	
	public ResponseEntity<Object> deleteUsuario(int id) {
		boolean existe = this.crudUsuario.existsById(id);
		
		if(!existe) {
			datos.put("error", true);
			datos.put("message", "El usuario no existe");
			return new ResponseEntity<>(datos,HttpStatus.CONFLICT);
		}
		crudUsuario.deleteById(id);
		datos.put("message", "Usuario Eliminado");
		return new ResponseEntity<>(datos,HttpStatus.ACCEPTED);
	}
}
