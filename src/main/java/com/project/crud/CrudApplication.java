package com.project.crud;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.crud.recursos.Usuario;

@SpringBootApplication
/*(1)Para que sea posible consumir o consultar información desde este archivo
con esta notación ya clase se convirtió en controlador*/
@RestController
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	
	/*(2)Si ejecuto el programa sin la notación GetMapping no muestra nada el navegador, al añadir la notación
	le digo a Spring que este metodo debe estar disponible*/
	
	/*
	@GetMapping(path = "/") //(3) "/" significa que iré a la ruta principal, al ejecutar ya muestra los nombres en formato Json en el navegador -** create package recursos y clase Usuario
	public List<String> getNames() {
		return List.of("Cris","Daniela","Mark");
	}*/
	
	
	/*(4) Al ejecutar este metodo se muestra en el navegador los datos ingresados 
	 * usando ya las variables de la clase usuario. Aqui se introdujeron manualmente
	 * pero estos datos deben provenir de la DB.
 
	@GetMapping(path = "/")
	public List<Usuario> getName() {
		return List.of (new Usuario(1,"Juan","Lopez","Lopez")); //Datos que deben provenir de DB
	}
	
	**Crear UsuarioController
	*(5) Cortamos este codigo y lo llevamos a Usuario Controller quitando (path = "/")
	*(6) Comento el primer getMapping en esta clase
	*/
}
