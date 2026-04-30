package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "InscripcionEvento")
public class InscripcionEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInscripcion")
    private int idInscripcion;

    @Column(name = "estadoAsistencia", length = 100)
    private String estadoAsistencia;

    @Column(name = "fechaInscripcion")
    private LocalDateTime fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "IdEvento", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "IdUsuario", nullable = false)
    private Usuario usuario;

    public InscripcionEvento() {}

    public int getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(int idInscripcion) { this.idInscripcion = idInscripcion; }
    public String getEstadoAsistencia() { return estadoAsistencia; }
    public void setEstadoAsistencia(String estadoAsistencia) { this.estadoAsistencia = estadoAsistencia; }
    public LocalDateTime getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDateTime fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}