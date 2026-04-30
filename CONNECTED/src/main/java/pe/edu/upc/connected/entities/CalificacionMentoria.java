package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CalificacionMentoria")
public class CalificacionMentoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMentoria;
    @Column(name = "puntuacionCalificacionMentoria",nullable =false )
    private int puntuacionCalificacionMentoria;
    @Column(name = "comentarioCalificacionMentoria",length =20 ,nullable =false )
    private String comentarioCalificacionMentoria;
    @Column(name = "dateCalificacionMentoria",nullable = false)
    private LocalDate dateCalificacionMentoria;

    @ManyToOne
    @JoinColumn(name = "idemisor")
    private Usuario emisor;

    @ManyToOne
    @JoinColumn(name = "idreceptor")
    private Usuario receptor;

    @ManyToOne
    @JoinColumn(name = "idmentorRecomendado")
    private Usuario mentorRecomendado;

    public CalificacionMentoria() {
    }

    public CalificacionMentoria(int idMentoria, int puntuacionCalificacionMentoria, String comentarioCalificacionMentoria, LocalDate dateCalificacionMentoria, Usuario emisor, Usuario receptor, Usuario mentorRecomendado) {
        this.idMentoria = idMentoria;
        this.puntuacionCalificacionMentoria = puntuacionCalificacionMentoria;
        this.comentarioCalificacionMentoria = comentarioCalificacionMentoria;
        this.dateCalificacionMentoria = dateCalificacionMentoria;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mentorRecomendado = mentorRecomendado;
    }

    public int getIdMentoria() {
        return idMentoria;
    }

    public void setIdMentoria(int idMentoria) {
        this.idMentoria = idMentoria;
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

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public Usuario getMentorRecomendado() {
        return mentorRecomendado;
    }

    public void setMentorRecomendado(Usuario mentorRecomendado) {
        this.mentorRecomendado = mentorRecomendado;
    }
}
