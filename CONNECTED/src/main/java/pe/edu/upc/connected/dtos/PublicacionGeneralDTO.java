package pe.edu.upc.connected.dtos;

import java.time.LocalDate;

public class PublicacionGeneralDTO {
    private int idPublicacion;
    private String contenidoPublicacion;
    private String tipoPublicacion;
    private String visibilidadPublicacion;
    private LocalDate fechaPublicacion;
    private int IdUsuario;

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

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }
}
