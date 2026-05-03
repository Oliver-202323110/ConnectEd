package pe.edu.upc.connected.entities;

import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TemaForo")
public class TemaForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdTema;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "contenido", length = 100, nullable = false)
    private String contenido;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "IdForo")
    private Foro foro;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public TemaForo() {
    }

    public TemaForo(int idTema, String titulo, String contenido, LocalDate fechaCreacion, Foro foro, Usuario usuario) {
        IdTema = idTema;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.foro = foro;
        this.usuario = usuario;
    }

    public int getIdTema() {
        return IdTema;
    }

    public void setIdTema(int idTema) {
        IdTema = idTema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Foro getForo() {
        return foro;
    }

    public void setForo(Foro foro) {
        this.foro = foro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
