package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class MentoriaGeneralDTO {
    private int idMentoria;
    private String estadoMentoria;
    private LocalDate fechaInicioMentoria;
    private LocalDate fechaFinMentoria;
    private int estudianteIdUsuario;
    private int mentorIdUsuario;

    public int getIdMentoria() {
        return idMentoria;
    }

    public void setIdMentoria(int idMentoria) {
        this.idMentoria = idMentoria;
    }

    public String getEstadoMentoria() {
        return estadoMentoria;
    }

    public void setEstadoMentoria(String estadoMentoria) {
        this.estadoMentoria = estadoMentoria;
    }

    public LocalDate getFechaInicioMentoria() {
        return fechaInicioMentoria;
    }

    public void setFechaInicioMentoria(LocalDate fechaInicioMentoria) {
        this.fechaInicioMentoria = fechaInicioMentoria;
    }

    public LocalDate getFechaFinMentoria() {
        return fechaFinMentoria;
    }

    public void setFechaFinMentoria(LocalDate fechaFinMentoria) {
        this.fechaFinMentoria = fechaFinMentoria;
    }

    public int getEstudianteIdUsuario() {
        return estudianteIdUsuario;
    }

    public void setEstudianteIdUsuario(int estudianteIdUsuario) {
        this.estudianteIdUsuario = estudianteIdUsuario;
    }

    public int getMentorIdUsuario() {
        return mentorIdUsuario;
    }

    public void setMentorIdUsuario(int mentorIdUsuario) {
        this.mentorIdUsuario = mentorIdUsuario;
    }
}
