package com.sena.spring96.service.usuario;

import java.util.List;

import com.sena.spring96.model.usuario.Usuario;

public interface IUsuarioService {
    
    public List<Usuario> findAll();
    public void save(Usuario usuario);
    public Usuario findOne(Integer id_usuario);
    public void delete(Integer id_usuario);
    
}
