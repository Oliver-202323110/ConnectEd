package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class ForoParticipanteGeneralDTO {
    private int IdForoParticipante;
    private LocalDate fechaUnion;
    private Foro foro;
    private Usuario usuario;

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
