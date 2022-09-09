package com.sena.spring96.service.factura;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.sena.spring96.model.factura.IFactura;
import com.sena.spring96.model.factura.Factura;

@Service
public class FacturaServicempl implements IFacturaService {

    @Autowired
    private IFactura fac;

    @Override
    public List<Factura> findAll() {
        
        return (List<Factura>) fac.findAll();
    }

    @Override
    public void save(Factura factura) {
       fac.save(factura);        
    }

    @Override
    public Factura findOne(Integer id) {
        
        return fac.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        fac.deleteById(id);
        
    }
    
}

