package com.kuspit.MiCasadeBolsa.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_usuario")
    private Integer pkUsuario;
    private String nombre;
    private String telefono;
    private String correo;
    private String contraseña;
    private Double saldo;

    ////RELACIONES
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;

    public int getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(int pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
