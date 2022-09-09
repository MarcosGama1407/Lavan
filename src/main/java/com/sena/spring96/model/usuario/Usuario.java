package com.sena.spring96.model.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sena.spring96.model.factura.Factura;


@Entity
@Table(name="usuarios")
public class Usuario {

        //Atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idUsuario;
        @NotEmpty
        @Size(min=2,max=50)
        @Column(length = 50,nullable=false)
        private String nombre;
        @NotEmpty
        @Size(min=2,max=50)
        @Column(length = 50,nullable=false)
        private String apellido;

        private String telefono;

        private String correo;

        private String contrasena;

        private boolean estado;

        private String rol;
    
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
        private List<Factura> facturas;

        //Metodo constructor vacio
        public Usuario(){
            facturas=new ArrayList<Factura>();
        }

        public Usuario(Integer idUsuario, @NotEmpty @Size(min = 2, max = 50) String nombre,
                @NotEmpty @Size(min = 2, max = 50) String apellido, String telefono, String correo, String contrasena,
                boolean estado, String rol, List<Factura> facturas) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
            this.correo = correo;
            this.contrasena = contrasena;
            this.estado = estado;
            this.rol = rol;
            this.facturas = facturas;
        }

        public Integer getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public boolean isEstado() {
            return estado;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }

        public List<Factura> getFacturas() {
            return facturas;
        }

        public void setFacturas(List<Factura> facturas) {
            this.facturas = facturas;
        }
    
        

        
}
