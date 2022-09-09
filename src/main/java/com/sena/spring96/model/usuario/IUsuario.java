package com.sena.spring96.model.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<Usuario,Integer>{

}