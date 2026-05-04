package pe.edu.upc.connected.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UsuarioSeguidor")
public class UsuarioSeguidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuarioSeguidor")
    private int idUsuarioSeguidor;

    @Column(name = "fechaInicio")
    private LocalDateTime fechaInicio;

    @Column(name = "estado", length = 100)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "IdSeguidor", nullable = false)
    private Usuario seguidor;

    @ManyToOne
    @JoinColumn(name = "IdSeguido", nullable = false)
    private Usuario seguido;

    public UsuarioSeguidor() {}

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