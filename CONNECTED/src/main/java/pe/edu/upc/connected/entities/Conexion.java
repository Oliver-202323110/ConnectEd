package pe.edu.upc.connected.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Conexion")
public class Conexion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdConexion")
    private int idConexion;

    @Column(name = "estado", length = 100)
    private String estado;

    @Column(name = "fechaSolicitud")
    private LocalDateTime fechaSolicitud;

    @Column(name = "fechaRespuesta")
    private LocalDateTime fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "IdUsuarioOrigen", nullable = false)
    private Usuario usuarioOrigen;

    @ManyToOne
    @JoinColumn(name = "IdUsuarioDestino", nullable = false)
    private Usuario usuarioDestino;

    public Conexion() {}

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