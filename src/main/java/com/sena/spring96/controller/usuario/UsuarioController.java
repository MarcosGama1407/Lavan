package com.sena.spring96.controller.usuario;

import javax.validation.Valid;

import com.sena.spring96.model.usuario.Usuario;
import com.sena.spring96.service.usuario.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("usuario")
@RequestMapping(value="/Usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuariod;
    
    @GetMapping(value="/listusuario")//Generar la URL y cargar el index
    public String listusuario(Model m){
        m.addAttribute("usuarios", usuariod.findAll());
        return "usuario/listusuario";
    }

    @GetMapping("/verc/{id_usuario}")
    public String verc(@PathVariable Integer id_usuario,Model m){
        Usuario usuario=null;
        if(id_usuario>0){
            usuario=usuariod.findOne(id_usuario);
        }else{
            return "redirect:listusuario";
        }
        m.addAttribute("usuario", usuario);
        return "usuario/vercusuario";
    }

    @GetMapping("/ver/{id_usuario}")
    public String ver(@PathVariable Integer id_usuario,Model m){
    Usuario usuario=null;
    if(id_usuario>0){
        usuario=usuariod.findOne(id_usuario);
    }else{
        return "redirect:listusuario";
    }
    m.addAttribute("usuario",usuario);
    m.addAttribute("accion", "Actualizar Usuario");
    return "usuario/editusuario";
    }

    @GetMapping("/form")
    public String form(Model m){
    Usuario usuario=new Usuario();
    m.addAttribute("usuario", usuario);
    m.addAttribute("accion", "Agregar Usuario");
    return "usuario/addusuario";
    }
    
    @PostMapping(value="/addusuario")//Generar la URL y cargar el index
    public String addusuario(@Valid Usuario usuario,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "usuario/addusuario";
            }
            usuariod.save(usuario);
            status.setComplete();
            return "redirect:listusuario";
    }

    @GetMapping("/delete/{id_usuario}")
    public String delete(@PathVariable Integer id_usuario){

    if(id_usuario>0){
        usuariod.delete(id_usuario);
    }
    return "redirect:../listusuario";
    }
}
