package com.project.crud.recursos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRol extends JpaRepository<Rol, Integer>{

	Optional<Rol> findRolByNombre(String nombre);
}
