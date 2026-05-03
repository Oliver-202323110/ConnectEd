package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RecomendacionMentor")
public class RecomendacionMentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    @Column(name = "comentarioRecomendacionMentor",length = 20,nullable = false)
    private String comentarioRecomendacionMentor;
    @Column(name = "utilidadRecomendacionMentor",length = 20,nullable = false)
    private String utilidadRecomendacionMentor;
    @Column(name = "fechaRecomendacionMentor",nullable = false)
    private LocalDate fechaRecomendacionMentor;

    @ManyToOne
    @JoinColumn(name = "idemisor")
    private Usuario emisor;

    @ManyToOne
    @JoinColumn(name = "idreceptor")
    private Usuario receptor;

    @ManyToOne
    @JoinColumn(name = "idmentorRecomendado")
    private Usuario mentorRecomendado;

    public RecomendacionMentor() {
    }

    public RecomendacionMentor(int idPublicacion, String comentarioRecomendacionMentor, String utilidadRecomendacionMentor, LocalDate fechaRecomendacionMentor, Usuario emisor, Usuario receptor, Usuario mentorRecomendado) {
        this.idPublicacion = idPublicacion;
        this.comentarioRecomendacionMentor = comentarioRecomendacionMentor;
        this.utilidadRecomendacionMentor = utilidadRecomendacionMentor;
        this.fechaRecomendacionMentor = fechaRecomendacionMentor;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mentorRecomendado = mentorRecomendado;
    }

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
