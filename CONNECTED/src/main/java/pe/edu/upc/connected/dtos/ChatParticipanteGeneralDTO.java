package pe.edu.upc.connected.dtos;

import pe.edu.upc.connected.entities.Chat;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class ChatParticipanteGeneralDTO {
    private int IdChatParticipante;
    private LocalDate fechaUnion;
    private Usuario usuario;
    private Chat chat;

    public int getIdChatParticipante() {
        return IdChatParticipante;
    }

    public void setIdChatParticipante(int idChatParticipante) {
        IdChatParticipante = idChatParticipante;
    }

    public LocalDate getFechaUnion() {
        return fechaUnion;
    }

    public void setFechaUnion(LocalDate fechaUnion) {
        this.fechaUnion = fechaUnion;
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
