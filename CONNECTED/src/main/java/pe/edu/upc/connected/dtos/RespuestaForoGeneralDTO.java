package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.TemaForo;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class RespuestaForoGeneralDTO {
    private int IdRespuestaForo;
    private String contenido;
    private LocalDate fechaRespuesta;
    private TemaForo temaForo;
    private Usuario usuario;

    public int getIdRespuestaForo() {
        return IdRespuestaForo;
    }

    public void setIdRespuestaForo(int idRespuestaForo) {
        IdRespuestaForo = idRespuestaForo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public TemaForo getTemaForo() {
        return temaForo;
    }

    public void setTemaForo(TemaForo temaForo) {
        this.temaForo = temaForo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
