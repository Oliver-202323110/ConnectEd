package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Usuario;
import java.time.LocalDateTime;

public class ConexionGeneralDTO {
    private int idConexion;
    private String estado;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaRespuesta;
    private Usuario usuarioOrigen;
    private Usuario usuarioDestino;

    public int getIdConexion() { return idConexion; }
    public void setIdConexion(int idConexion) { this.idConexion = idConexion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public LocalDateTime getFechaRespuesta() { return fechaRespuesta; }
    public void setFechaRespuesta(LocalDateTime fechaRespuesta) { this.fechaRespuesta = fechaRespuesta; }
    public Usuario getUsuarioOrigen() { return usuarioOrigen; }
    public void setUsuarioOrigen(Usuario usuarioOrigen) { this.usuarioOrigen = usuarioOrigen; }
    public Usuario getUsuarioDestino() { return usuarioDestino; }
    public void setUsuarioDestino(Usuario usuarioDestino) { this.usuarioDestino = usuarioDestino; }
}