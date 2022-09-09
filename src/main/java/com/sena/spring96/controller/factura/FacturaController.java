package com.sena.spring96.controller.factura;


import javax.validation.Valid;

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

import com.sena.spring96.model.factura.Factura;
import com.sena.spring96.service.factura.IFacturaService;


@Controller
@SessionAttributes("factura")
@RequestMapping("/Factura")
public class FacturaController {
    
    @Autowired
    private IFacturaService facturad;

    @GetMapping(path={"/listfactura"})
    public String listar(Model m){
        m.addAttribute("facturas", facturad.findAll());
        return "factura/listfactura";    
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id,Model m){
        Factura factura=null;
        if(id>0){
            factura=facturad.findOne(id);

        }else{
            return "redirect:listfactura";
        }
        m.addAttribute("factura",factura);
        m.addAttribute("accion", "Actualizar Factura");
        return "factura/addfactura";
    }

    @GetMapping("/form")
    public String form(Model m){
        Factura factura=new Factura();
        m.addAttribute("factura", factura);
        m.addAttribute("accion", "Agregar Factura");
        return "factura/addfactura"; 

    }

    @PostMapping("/addfactura")
    public String addfactura(@Valid Factura factura,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
            return "factura/addfactura";
        }
        facturad.save(factura);
        status.setComplete();
        return "redirect:listfactura";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        if(id > 0){
            facturad.delete(id);
        }
        return "redirect:../listfactura";
    }

}


