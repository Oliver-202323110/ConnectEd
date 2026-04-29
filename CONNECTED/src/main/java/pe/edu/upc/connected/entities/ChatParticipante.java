package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ChatParticipante")
public class ChatParticipante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdChatParticipante;

    @Column(name = "fechaUnion", nullable = false)
    private LocalDate fechaUnion;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IdChat")
    private Chat chat;

    public ChatParticipante() {
    }

    public ChatParticipante(int idChatParticipante, LocalDate fechaUnion, Usuario usuario, Chat chat) {
        IdChatParticipante = idChatParticipante;
        this.fechaUnion = fechaUnion;
        this.usuario = usuario;
        this.chat = chat;
    }

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
