package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class GrupoNetworkingGeneralDTO {
    private int IdGrupo;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String privacidad;
    private Usuario usuario;

    public int getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        IdGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
