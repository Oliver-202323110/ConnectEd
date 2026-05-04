package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Chat;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class MensajeGeneralDTO {
    private int IdMensaje;
    private String contenido;
    private LocalDate fechaEnvio;
    private boolean leido;
    private Usuario usuario;
    private Chat chat;

    public int getIdMensaje() {
        return IdMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        IdMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
