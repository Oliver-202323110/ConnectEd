package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Usuario;
import java.time.LocalDateTime;

public class UsuarioSeguidorGeneralDTO {
    private int idUsuarioSeguidor;
    private LocalDateTime fechaInicio;
    private String estado;
    private Usuario seguidor;
    private Usuario seguido;

    public int getIdUsuarioSeguidor() { return idUsuarioSeguidor; }
    public void setIdUsuarioSeguidor(int idUsuarioSeguidor) { this.idUsuarioSeguidor = idUsuarioSeguidor; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Usuario getSeguidor() { return seguidor; }
    public void setSeguidor(Usuario seguidor) { this.seguidor = seguidor; }
    public Usuario getSeguido() { return seguido; }
    public void setSeguido(Usuario seguido) { this.seguido = seguido; }
}