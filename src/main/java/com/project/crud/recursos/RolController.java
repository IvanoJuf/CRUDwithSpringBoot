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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RolController {
	
	private final RolService rolService;
	
	@Autowired
	public RolController(RolService rolService) {
		this.rolService = rolService;
	}

	@GetMapping
	public List<Rol> getRoles() {
		return this.rolService.getRoles();
	}
	
	@PostMapping
	public void registrarRol(@RequestBody Rol rol) {
		this.rolService.nuevoRol(rol);
	}
	
	@PutMapping
	public void actualizarRol(@RequestBody Rol rol) {
		this.rolService.nuevoRol(rol);
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> eliminarRol(@PathVariable("id") int id) {
		return this.rolService.deleteRol(id);
	}
}
