package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdChat;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    public Chat() {
    }

    public Chat(int idChat, String tipo, String estado, LocalDate fechaCreacion) {
        IdChat = idChat;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

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
