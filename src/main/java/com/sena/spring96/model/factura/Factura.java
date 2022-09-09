package com.sena.spring96.model.factura;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sena.spring96.model.usuario.Usuario;

@Entity
@Table(name="facturas")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreCliente;

    private Date fecha;


    @Column(nullable = false)
    private boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Usuario", nullable = false, updatable = false)
    private Usuario usuario;

    public Factura(){

    }


    public Factura(Integer id, String nombreCliente, Date fecha, boolean estado) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }


    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public boolean isEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

