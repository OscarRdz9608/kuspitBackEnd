package com.kuspit.MiCasadeBolsa.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "acciones")
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accion")
    private Integer idAccion;

    private String simbolo;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "ultimo_precio")
    private double ultimoPrecio;

    private String volumen;

    @OneToMany(mappedBy = "accion")
    private List<Transaccion> transacciones;

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getUltimoPrecio() {
        return ultimoPrecio;
    }

    public void setUltimoPrecio(double ultimoPrecio) {
        this.ultimoPrecio = ultimoPrecio;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}
