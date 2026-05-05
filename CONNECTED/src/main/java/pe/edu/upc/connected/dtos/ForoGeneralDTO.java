package pe.edu.upc.connected.dtos;

import jakarta.persistence.*;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class ForoGeneralDTO {
    private int IdForo;
    private String titulo;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    private int idUsuario;

    public int getIdForo() {
        return IdForo;
    }

    public void setIdForo(int idForo) {
        IdForo = idForo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
