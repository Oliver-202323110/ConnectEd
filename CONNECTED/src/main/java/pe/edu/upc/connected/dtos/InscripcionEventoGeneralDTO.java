package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Evento;
import pe.edu.upc.connected.entities.Usuario;
import java.time.LocalDateTime;

public class InscripcionEventoGeneralDTO {
    private int idInscripcion;
    private String estadoAsistencia;
    private LocalDateTime fechaInscripcion;
    private Evento evento;
    private Usuario usuario;

    public int getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(int idInscripcion) { this.idInscripcion = idInscripcion; }
    public String getEstadoAsistencia() { return estadoAsistencia; }
    public void setEstadoAsistencia(String estadoAsistencia) { this.estadoAsistencia = estadoAsistencia; }
    public LocalDateTime getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDateTime fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}