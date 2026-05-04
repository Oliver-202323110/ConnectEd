package pe.edu.upc.connected.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SolicitudRecomendacion")
public class SolicitudRecomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSolicitud")
    private int idSolicitud;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "mensaje", columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "estado", length = 100)
    private String estado;

    @Column(name = "fechaSolicitud")
    private LocalDateTime fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "IdSolicitante", nullable = false)
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(name = "IdDestinatario", nullable = false)
    private Usuario destinatario;

    public SolicitudRecomendacion() {}

    public int getIdSolicitud() { return idSolicitud; }
    public void setIdSolicitud(int idSolicitud) { this.idSolicitud = idSolicitud; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public Usuario getSolicitante() { return solicitante; }
    public void setSolicitante(Usuario solicitante) { this.solicitante = solicitante; }
    public Usuario getDestinatario() { return destinatario; }
    public void setDestinatario(Usuario destinatario) { this.destinatario = destinatario; }
}
