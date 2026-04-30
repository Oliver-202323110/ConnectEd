package pe.edu.upc.connected.dtos;

import java.time.LocalDate;

public class ChatGeneralDTO {
    private int IdChat;
    private String tipo;
    private String estado;
    private LocalDate fechaCreacion;

    public int getIdChat() {
        return IdChat;
    }

    public void setIdChat(int idChat) {
        IdChat = idChat;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
