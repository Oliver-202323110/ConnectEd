package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class RecomendacionMentorGeneralDTO {
    private int idPublicacion;
    private String comentarioRecomendacionMentor;
    private String utilidadRecomendacionMentor;
    private LocalDate fechaRecomendacionMentor;
    private int emisorId;
    private int receptorId;
    private int mentorRecomendadoid;

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getComentarioRecomendacionMentor() {
        return comentarioRecomendacionMentor;
    }

    public void setComentarioRecomendacionMentor(String comentarioRecomendacionMentor) {
        this.comentarioRecomendacionMentor = comentarioRecomendacionMentor;
    }

    public String getUtilidadRecomendacionMentor() {
        return utilidadRecomendacionMentor;
    }

    public void setUtilidadRecomendacionMentor(String utilidadRecomendacionMentor) {
        this.utilidadRecomendacionMentor = utilidadRecomendacionMentor;
    }

    public LocalDate getFechaRecomendacionMentor() {
        return fechaRecomendacionMentor;
    }

    public void setFechaRecomendacionMentor(LocalDate fechaRecomendacionMentor) {
        this.fechaRecomendacionMentor = fechaRecomendacionMentor;
    }

    public int getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(int emisorId) {
        this.emisorId = emisorId;
    }

    public int getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(int receptorId) {
        this.receptorId = receptorId;
    }

    public int getMentorRecomendadoid() {
        return mentorRecomendadoid;
    }

    public void setMentorRecomendadoid(int mentorRecomendadoid) {
        this.mentorRecomendadoid = mentorRecomendadoid;
    }
}
