package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPerfil;

    @Column(name = "fotoURL", length = 200, nullable = false)
    private String fotoURL;

    @Column(name = "tituloProfesional", length = 200, nullable = false)
    private String tituloProfesional;

    @Column(name = "biografia", length = 200, nullable = false)
    private String biografia;

    @Column(name = "institucion", length = 100, nullable = false)
    private String institucion;

    @Column(name = "ubicacion", length = 200, nullable = false)
    private String ubicacion;

    @Column(name = "habilidades", length = 200, nullable = false)
    private String habilidades;

    @Column(name = "intereses", length = 200, nullable = false)
    private String intereses;

    @Column(name = "disponibilidad", length = 200, nullable = false)
    private String disponibilidad;

    @Column(name = "visibilidad", length = 100, nullable = false)
    private String visibilidad;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDate fechaActualizacion;

    @OneToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public Perfil() {
    }

    public Perfil(int idPerfil, String fotoURL, String tituloProfesional, String biografia, String institucion, String ubicacion, String habilidades, String intereses, String disponibilidad, String visibilidad, LocalDate fechaActualizacion, Usuario usuario) {
        IdPerfil = idPerfil;
        this.fotoURL = fotoURL;
        this.tituloProfesional = tituloProfesional;
        this.biografia = biografia;
        this.institucion = institucion;
        this.ubicacion = ubicacion;
        this.habilidades = habilidades;
        this.intereses = intereses;
        this.disponibilidad = disponibilidad;
        this.visibilidad = visibilidad;
        this.fechaActualizacion = fechaActualizacion;
        this.usuario = usuario;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        IdPerfil = idPerfil;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

