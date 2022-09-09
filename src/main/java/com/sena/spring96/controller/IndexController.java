package com.sena.spring96.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndexController {
    @GetMapping(path = {"/home","/"})//Generar la URL y cargar el index
    /*public String index(Model m){
        m.addAttribute("msn", "Este mensaje viene del controlador");
        return "index";
    }*/

    public ModelAndView index(ModelAndView mv){
        mv.setViewName("Inicio/inicio");
        return mv;
    }

}
