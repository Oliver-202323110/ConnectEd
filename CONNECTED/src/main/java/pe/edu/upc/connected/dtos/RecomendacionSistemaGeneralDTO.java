package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class RecomendacionSistemaGeneralDTO {
    private int IdRecomendacion;
    private String tipo;
    private String motivo;
    private String estado;
    private LocalDate fechaGenerada;
    private Usuario usuario;

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
