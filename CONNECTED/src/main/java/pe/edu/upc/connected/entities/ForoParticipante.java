package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ForoParticipante")
public class ForoParticipante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdForoParticipante;

    @Column(name = "fechaUnion", nullable = false)
    private LocalDate fechaUnion;

    @ManyToOne
    @JoinColumn(name = "IdForo")
    private Foro foro;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public ForoParticipante() {
    }

    public ForoParticipante(int idForoParticipante, LocalDate fechaUnion, Foro foro, Usuario usuario) {
        IdForoParticipante = idForoParticipante;
        this.fechaUnion = fechaUnion;
        this.foro = foro;
        this.usuario = usuario;
    }

    public int getIdForoParticipante() {
        return IdForoParticipante;
    }

    public void setIdForoParticipante(int idForoParticipante) {
        IdForoParticipante = idForoParticipante;
    }

    public LocalDate getFechaUnion() {
        return fechaUnion;
    }

    public void setFechaUnion(LocalDate fechaUnion) {
        this.fechaUnion = fechaUnion;
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
