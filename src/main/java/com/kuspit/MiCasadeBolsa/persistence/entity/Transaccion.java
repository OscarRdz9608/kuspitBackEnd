package com.kuspit.MiCasadeBolsa.persistence.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_transaccion")
    private Integer pkTransaccion;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    @Column(name = "fk_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_accion")
    @Column(name = "fk_accion")
    private Accion accion;

    @Column(name = "fecha_transaccion")
    private LocalDateTime fechaTransaccion;
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;




}
