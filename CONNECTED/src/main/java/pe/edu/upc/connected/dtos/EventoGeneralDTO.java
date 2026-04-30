package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Usuario;
import java.time.LocalDateTime;

public class EventoGeneralDTO {
    private int idEvento;
    private String titulo;
    private String descripcion;
    private String tipo;
    private String modalidad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String enlaceAcceso;
    private String grabacionURL;
    private Integer cupos;
    private Usuario usuario;

    public int getIdEvento() { return idEvento; }
    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }
    public String getEnlaceAcceso() { return enlaceAcceso; }
    public void setEnlaceAcceso(String enlaceAcceso) { this.enlaceAcceso = enlaceAcceso; }
    public String getGrabacionURL() { return grabacionURL; }
    public void setGrabacionURL(String grabacionURL) { this.grabacionURL = grabacionURL; }
    public Integer getCupos() { return cupos; }
    public void setCupos(Integer cupos) { this.cupos = cupos; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}