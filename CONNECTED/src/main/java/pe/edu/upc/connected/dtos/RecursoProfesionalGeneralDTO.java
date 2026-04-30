package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;

public class RecursoProfesionalGeneralDTO {
    private int idRecursoProfesional;
    private String tituloRecursoProfesional;
    private String categoriaRecursoProfesional;
    private String urlRecursoProfesional;
    private String formatoRecursoProfesional;
    private String descripcionformatoRecursoProfesional;
    private int idPublicacion;

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

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
}
