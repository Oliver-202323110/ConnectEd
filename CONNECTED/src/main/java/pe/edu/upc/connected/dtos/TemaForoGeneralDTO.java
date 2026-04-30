package pe.edu.upc.connected.dtos;

import jakarta.persistence.*;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class TemaForoGeneralDTO {
    private int IdTema;
    private String titulo;
    private String contenido;
    private LocalDate fechaCreacion;
    private Foro foro;
    private Usuario usuario;

    public int getIdTema() {
        return IdTema;
    }

    public void setIdTema(int idTema) {
        IdTema = idTema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Foro getForo() {
        return foro;
    }

    public void setForo(Foro foro) {
        this.foro = foro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
