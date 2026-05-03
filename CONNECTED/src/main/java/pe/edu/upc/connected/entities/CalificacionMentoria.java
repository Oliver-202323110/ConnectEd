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



    public CalificacionMentoria() {
    }

    public CalificacionMentoria(int idMentoria, int puntuacionCalificacionMentoria, String comentarioCalificacionMentoria, LocalDate dateCalificacionMentoria, Usuario emisor, Usuario receptor, Usuario mentorRecomendado) {
        this.idMentoria = idMentoria;
        this.puntuacionCalificacionMentoria = puntuacionCalificacionMentoria;
        this.comentarioCalificacionMentoria = comentarioCalificacionMentoria;
        this.dateCalificacionMentoria = dateCalificacionMentoria;

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

}
