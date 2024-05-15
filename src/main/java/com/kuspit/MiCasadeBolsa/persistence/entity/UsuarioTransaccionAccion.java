package com.kuspit.MiCasadeBolsa.persistence.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="usuarios_transacciones_acciones")
public class UsuarioTransaccionAccion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario_transaccion_accion")
    private String idUsuarioTransaccionAccion;
    @Column(name = "id_usuario")
    private String idUsuario;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "simbolo_accion")
    private String simboloAccion;
    @Column(name = "nombre_empresa_accion")
    private String nombreEmpresaAccion;
    @Column(name = "")
    private double precioAccion;
    @Column(name = "volumen_accion")
    private int volumenAccion;
    @Column(name = "fecha_transaccion")
    private LocalDateTime fechaTransaccion;

    public String getIdUsuarioTransaccionAccion() {
        return idUsuarioTransaccionAccion;
    }

    public void setIdUsuarioTransaccionAccion(String idUsuarioTransaccionAccion) {
        this.idUsuarioTransaccionAccion = idUsuarioTransaccionAccion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getSimboloAccion() {
        return simboloAccion;
    }

    public void setSimboloAccion(String simboloAccion) {
        this.simboloAccion = simboloAccion;
    }

    public String getNombreEmpresaAccion() {
        return nombreEmpresaAccion;
    }

    public void setNombreEmpresaAccion(String nombreEmpresaAccion) {
        this.nombreEmpresaAccion = nombreEmpresaAccion;
    }

    public double getPrecioAccion() {
        return precioAccion;
    }

    public void setPrecioAccion(double precioAccion) {
        this.precioAccion = precioAccion;
    }

    public int getVolumenAccion() {
        return volumenAccion;
    }

    public void setVolumenAccion(int volumenAccion) {
        this.volumenAccion = volumenAccion;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}
