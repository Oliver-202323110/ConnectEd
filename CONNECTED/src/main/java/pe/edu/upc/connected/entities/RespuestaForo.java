package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RespuestaForo")
public class RespuestaForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRespuestaForo;

    @Column(name = "contenido", length = 200, nullable = false)
    private String contenido;

    @Column(name = "fechaRespuesta", nullable = false)
    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "IdTema")
    private TemaForo temaForo;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public RespuestaForo() {
    }

    public RespuestaForo(int idRespuestaForo, String contenido, LocalDate fechaRespuesta, TemaForo temaForo, Usuario usuario) {
        IdRespuestaForo = idRespuestaForo;
        this.contenido = contenido;
        this.fechaRespuesta = fechaRespuesta;
        this.temaForo = temaForo;
        this.usuario = usuario;
    }

    public int getIdRespuestaForo() {
        return IdRespuestaForo;
    }

    public void setIdRespuestaForo(int idRespuestaForo) {
        IdRespuestaForo = idRespuestaForo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDate fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public TemaForo getTemaForo() {
        return temaForo;
    }

    public void setTemaForo(TemaForo temaForo) {
        this.temaForo = temaForo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
