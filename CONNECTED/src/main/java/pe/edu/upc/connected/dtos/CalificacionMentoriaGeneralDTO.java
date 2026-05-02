package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class CalificacionMentoriaGeneralDTO {
    private int idCalificacionMentoria;
    private int puntuacionCalificacionMentoria;
    private String comentarioCalificacionMentoria;
    private LocalDate dateCalificacionMentoria;
    private int mentoriaIdMentoria;
    private int usuarioIdUsuario;

    public int getIdCalificacionMentoria() {
        return idCalificacionMentoria;
    }

    public void setIdCalificacionMentoria(int idCalificacionMentoria) {
        this.idCalificacionMentoria = idCalificacionMentoria;
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

    public int getMentoriaIdMentoria() {
        return mentoriaIdMentoria;
    }

    public void setMentoriaIdMentoria(int mentoriaIdMentoria) {
        this.mentoriaIdMentoria = mentoriaIdMentoria;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
}
