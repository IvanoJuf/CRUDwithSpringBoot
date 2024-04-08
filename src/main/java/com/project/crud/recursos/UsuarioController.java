package com.project.crud.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//(1) añadimos notaciones
@RestController
@RequestMapping(path = "api/v1/usuarios") //Especifico el estandar - tipo (api)/version/recurso
public class UsuarioController {

	
	//(2) Traemos el metodo GetMapping que extrae info de DB de la clase CrudApplication
	/*
	 * (3) Corto el metodo public List<Usuario> y lo llevo a la clase UsuarioService sin la notación GetMapping
	 * y hago aqui algo llamado "Inyección de dependencias"
	@GetMapping 
	public List<Usuario> getUsuarios() {
		return List.of (new Usuario(1,"Mark","Lopez","Lopez")); //Datos que deben provenir de DB
	}
	*/
	
	private final UsuarioService usuarioService;
	
	//(4) Aqí ya se conecto la clase UsuarioService con el controlador
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return this.usuarioService.getUsuarios();
	}
	
	@PostMapping
	public void registrarUsuario(@RequestBody Usuario usuario,@RequestParam("id_trole") int idRol) {
		this.usuarioService.nuevoUsuario(usuario,idRol);
	}
	
	@PutMapping
	public void actualizarUsuario(@RequestBody Usuario usuario,@RequestParam("id_trole") int idRol) {
		this.usuarioService.nuevoUsuario(usuario,idRol);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") int id) {
		return this.usuarioService.deleteUsuario(id);
	}
}
