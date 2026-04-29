package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.Perfil;

public class EnlacePerfilGeneralDTO {
    private int IdEnlace;
    private String tipo;
    private String URL;
    private Perfil perfil;

    public int getIdEnlace() {
        return IdEnlace;
    }

    public void setIdEnlace(int idEnlace) {
        IdEnlace = idEnlace;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
