package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SolicitudChat")
public class SolicitudChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdSolicitudChat;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "fechaEnvio", nullable = false)
    private LocalDate fechaEnvio;

    @Column(name = "fechaRespuesta")
    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public SolicitudChat() {
    }

    public SolicitudChat(int idSolicitudChat, String estado, LocalDate fechaEnvio, LocalDate fechaRespuesta, Usuario usuario) {
        IdSolicitudChat = idSolicitudChat;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.fechaRespuesta = fechaRespuesta;
        this.usuario = usuario;
    }

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
