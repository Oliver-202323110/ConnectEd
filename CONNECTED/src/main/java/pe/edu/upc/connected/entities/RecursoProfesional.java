package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RecursoProfesional")
public class RecursoProfesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecursoProfesional;
    @Column(name = "tituloRecursoProfesional",length = 20,nullable = false)
    private String tituloRecursoProfesional;
    @Column(name = "categoriaRecursoProfesional",length = 20,nullable = false)
    private String categoriaRecursoProfesional;
    @Column(name = "urlRecursoProfesional",length = 20,nullable = false)
    private String urlRecursoProfesional;
    @Column(name = "formatoRecursoProfesional",length = 20,nullable = false)
    private String formatoRecursoProfesional;
    @Column(name = "descripcionformatoRecursoProfesional",length = 20,nullable = false)
    private String descripcionformatoRecursoProfesional;
    @ManyToOne
    @JoinColumn(name = "idPublicacion")
    private Publicacion publicacion;

    public RecursoProfesional() {
    }

    public RecursoProfesional(int idRecursoProfesional, String tituloRecursoProfesional, String categoriaRecursoProfesional, String urlRecursoProfesional, String formatoRecursoProfesional, String descripcionformatoRecursoProfesional, Publicacion publicacion) {
        this.idRecursoProfesional = idRecursoProfesional;
        this.tituloRecursoProfesional = tituloRecursoProfesional;
        this.categoriaRecursoProfesional = categoriaRecursoProfesional;
        this.urlRecursoProfesional = urlRecursoProfesional;
        this.formatoRecursoProfesional = formatoRecursoProfesional;
        this.descripcionformatoRecursoProfesional = descripcionformatoRecursoProfesional;
        this.publicacion = publicacion;
    }

    public int getIdRecursoProfesional() {
        return idRecursoProfesional;
    }

    public void setIdRecursoProfesional(int idRecursoProfesional) {
        this.idRecursoProfesional = idRecursoProfesional;
    }

    public String getTituloRecursoProfesional() {
        return tituloRecursoProfesional;
    }

    public void setTituloRecursoProfesional(String tituloRecursoProfesional) {
        this.tituloRecursoProfesional = tituloRecursoProfesional;
    }

    public String getCategoriaRecursoProfesional() {
        return categoriaRecursoProfesional;
    }

    public void setCategoriaRecursoProfesional(String categoriaRecursoProfesional) {
        this.categoriaRecursoProfesional = categoriaRecursoProfesional;
    }

    public String getUrlRecursoProfesional() {
        return urlRecursoProfesional;
    }

    public void setUrlRecursoProfesional(String urlRecursoProfesional) {
        this.urlRecursoProfesional = urlRecursoProfesional;
    }

    public String getFormatoRecursoProfesional() {
        return formatoRecursoProfesional;
    }

    public void setFormatoRecursoProfesional(String formatoRecursoProfesional) {
        this.formatoRecursoProfesional = formatoRecursoProfesional;
    }

    public String getDescripcionformatoRecursoProfesional() {
        return descripcionformatoRecursoProfesional;
    }

    public void setDescripcionformatoRecursoProfesional(String descripcionformatoRecursoProfesional) {
        this.descripcionformatoRecursoProfesional = descripcionformatoRecursoProfesional;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
