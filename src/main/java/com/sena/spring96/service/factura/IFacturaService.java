package com.sena.spring96.service.factura;

import java.util.List;

import com.sena.spring96.model.factura.Factura;

public interface IFacturaService {
    
    List<Factura> findAll = null;
    public List<Factura> findAll();
    public void save (Factura factura);
    public Factura findOne(Integer id);
    public void delete(Integer id);

}
