package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdForo;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public Foro() {
    }

    public Foro(int idForo, String titulo, String descripcion, String estado, LocalDate fechaCreacion, Usuario usuario) {
        IdForo = idForo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
    }

    public int getIdForo() {
        return IdForo;
    }

    public void setIdForo(int idForo) {
        IdForo = idForo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
