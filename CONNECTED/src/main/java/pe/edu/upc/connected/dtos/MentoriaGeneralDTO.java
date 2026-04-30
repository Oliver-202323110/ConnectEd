package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class MentoriaGeneralDTO {
    private int idMentoria;
    private String estadoMentoria;
    private LocalDate fechaInicioMentoria;
    private LocalDate fechaFinMentoria;
    private int idusuarioestudiante;
    private int idusuariomentor;

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

    public int getIdusuarioestudiante() {
        return idusuarioestudiante;
    }

    public void setIdusuarioestudiante(int idusuarioestudiante) {
        this.idusuarioestudiante = idusuarioestudiante;
    }

    public int getIdusuariomentor() {
        return idusuariomentor;
    }

    public void setIdusuariomentor(int idusuariomentor) {
        this.idusuariomentor = idusuariomentor;
    }
}
