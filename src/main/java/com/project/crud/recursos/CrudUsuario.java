package com.project.crud.recursos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudUsuario extends JpaRepository<Usuario, Integer> {

	//Este comando es lo mismo que: select * from usuario x where x.name= ?1
	Optional<Usuario> findUsuarioByNombre(String nombre);
}
