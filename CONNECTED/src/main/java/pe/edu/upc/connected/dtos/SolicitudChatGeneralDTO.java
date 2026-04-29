package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class SolicitudChatGeneralDTO {
    private int IdSolicitudChat;
    private String estado;
    private LocalDate fechaEnvio;
    private LocalDate fechaRespuesta;
    private Usuario usuario;

    public int getIdSolicitudChat() {
        return IdSolicitudChat;
    }

    public void setIdSolicitudChat(int idSolicitudChat) {
        IdSolicitudChat = idSolicitudChat;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
