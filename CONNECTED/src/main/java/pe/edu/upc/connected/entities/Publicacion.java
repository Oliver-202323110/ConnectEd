package pe.edu.upc.connected.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    @Column(name = "contenidoPublicacion",length = 20,nullable = false)
    private String contenidoPublicacion;
    @Column(name = "tipoPublicacion",length = 20,nullable = false)
    private String tipoPublicacion;
    @Column(name = "visibilidadPublicacion",length = 20,nullable = false)
    private String visibilidadPublicacion;
    @Column(name = "fechaPublicacion",nullable = false)
    private LocalDate fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Publicacion() {
    }

    public Publicacion(int idPublicacion, String contenidoPublicacion, String tipoPublicacion, String visibilidadPublicacion, LocalDate fechaPublicacion, Usuario usuario) {
        this.idPublicacion = idPublicacion;
        this.contenidoPublicacion = contenidoPublicacion;
        this.tipoPublicacion = tipoPublicacion;
        this.visibilidadPublicacion = visibilidadPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.usuario = usuario;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getContenidoPublicacion() {
        return contenidoPublicacion;
    }

    public void setContenidoPublicacion(String contenidoPublicacion) {
        this.contenidoPublicacion = contenidoPublicacion;
    }

    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public String getVisibilidadPublicacion() {
        return visibilidadPublicacion;
    }

    public void setVisibilidadPublicacion(String visibilidadPublicacion) {
        this.visibilidadPublicacion = visibilidadPublicacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
