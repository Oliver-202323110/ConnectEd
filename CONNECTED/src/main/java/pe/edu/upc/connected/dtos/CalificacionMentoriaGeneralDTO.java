package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class CalificacionMentoriaGeneralDTO {
    private int idCalificacion;
    private int puntuacionCalificacionMentoria;
    private String comentarioCalificacionMentoria;
    private LocalDate dateCalificacionMentoria;
    private int idMentoria;
    private int idUsuario;

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

    public int getIdMentoria() {
        return idMentoria;
    }

    public void setIdMentoria(int idMentoria) {
        this.idMentoria = idMentoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
