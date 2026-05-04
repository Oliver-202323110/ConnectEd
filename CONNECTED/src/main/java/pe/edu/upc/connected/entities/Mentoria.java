package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Mentoria")
public class Mentoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMentoria;
    @Column(name = "estadoMentoria",length = 20,nullable = false)
    private String estadoMentoria;
    @Column(name = "fechaInicioMentoria",nullable = false)
    private LocalDate fechaInicioMentoria;
    @Column(name = "fechaFinMentoria",nullable = false)
    private LocalDate fechaFinMentoria;

    @ManyToOne
    @JoinColumn(name = "idusuarioestudiante")
    private Usuario estudiante;

    @ManyToOne
    @JoinColumn(name = "idusuariomentor")
    private Usuario mentor;

    public Mentoria() {
    }

    public Mentoria(int idMentoria, String estadoMentoria, LocalDate fechaInicioMentoria, LocalDate fechaFinMentoria, Usuario estudiante, Usuario mentor) {
        this.idMentoria = idMentoria;
        this.estadoMentoria = estadoMentoria;
        this.fechaInicioMentoria = fechaInicioMentoria;
        this.fechaFinMentoria = fechaFinMentoria;
        this.estudiante = estudiante;
        this.mentor = mentor;
    }

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

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public Usuario getMentor() {
        return mentor;
    }

    public void setMentor(Usuario mentor) {
        this.mentor = mentor;
    }
}
