package com.sena.spring96.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.spring96.model.usuario.IUsuario;
import com.sena.spring96.model.usuario.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private IUsuario usuariod;

    @Override
    public List<Usuario> findAll() {
        
        return (List<Usuario>) usuariod.findAll();
    }

    @Override
    public void save(Usuario usuario) {
       usuariod.save(usuario);        
    }

    @Override
    public Usuario findOne(Integer id_usuario) {
        
        return usuariod.findById(id_usuario).orElse(null);
    }

    @Override
    public void delete(Integer id_usuario) {
        usuariod.deleteById(id_usuario);
        
    }
 
}