package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CalificacionMentoria")
public class CalificacionMentoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalificacion;
    @Column(name = "puntuacionCalificacionMentoria",nullable =false )
    private int puntuacionCalificacionMentoria;
    @Column(name = "comentarioCalificacionMentoria",length =20 ,nullable =false )
    private String comentarioCalificacionMentoria;
    @Column(name = "dateCalificacionMentoria",nullable = false)
    private LocalDate dateCalificacionMentoria;

    @OneToOne
    @JoinColumn(name = "idMentoria", unique = true, nullable = false)
    private Mentoria mentoria;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;



    public CalificacionMentoria() {
    }

    public CalificacionMentoria(int idCalificacion, int puntuacionCalificacionMentoria, String comentarioCalificacionMentoria, LocalDate dateCalificacionMentoria, Mentoria mentoria, Usuario usuario) {
        this.idCalificacion = idCalificacion;
        this.puntuacionCalificacionMentoria = puntuacionCalificacionMentoria;
        this.comentarioCalificacionMentoria = comentarioCalificacionMentoria;
        this.dateCalificacionMentoria = dateCalificacionMentoria;
        this.mentoria = mentoria;
        this.usuario = usuario;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getPuntuacionCalificacionMentoria() {
        return puntuacionCalificacionMentoria;
    }

    public void setPuntuacionCalificacionMentoria(int puntuacionCalificacionMentoria) {
        this.puntuacionCalificacionMentoria = puntuacionCalificacionMentoria;
    }

    public String getComentarioCalificacionMentoria() {
        return comentarioCalificacionMentoria;
    }

    public void setComentarioCalificacionMentoria(String comentarioCalificacionMentoria) {
        this.comentarioCalificacionMentoria = comentarioCalificacionMentoria;
    }

    public LocalDate getDateCalificacionMentoria() {
        return dateCalificacionMentoria;
    }

    public void setDateCalificacionMentoria(LocalDate dateCalificacionMentoria) {
        this.dateCalificacionMentoria = dateCalificacionMentoria;
    }

    public Mentoria getMentoria() {
        return mentoria;
    }

    public void setMentoria(Mentoria mentoria) {
        this.mentoria = mentoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
