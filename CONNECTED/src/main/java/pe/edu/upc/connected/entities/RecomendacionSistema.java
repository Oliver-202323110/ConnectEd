package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

public class RecomendacionSistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRecomendacion;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "motivo", length = 100, nullable = false)
    private String motivo;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "fechaGenerada", nullable = false)
    private LocalDate fechaGenerada;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public RecomendacionSistema() {
    }

    public RecomendacionSistema(int idRecomendacion, String tipo, String motivo, String estado, LocalDate fechaGenerada, Usuario usuario) {
        IdRecomendacion = idRecomendacion;
        this.tipo = tipo;
        this.motivo = motivo;
        this.estado = estado;
        this.fechaGenerada = fechaGenerada;
        this.usuario = usuario;
    }

    public int getIdRecomendacion() {
        return IdRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        IdRecomendacion = idRecomendacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaGenerada() {
        return fechaGenerada;
    }

    public void setFechaGenerada(LocalDate fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
