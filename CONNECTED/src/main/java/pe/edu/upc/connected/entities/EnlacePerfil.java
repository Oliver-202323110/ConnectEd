package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EnlacePerfil")
public class EnlacePerfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdEnlace;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "URL", length = 50, nullable = false)
    private String URL;

    @ManyToOne
    @JoinColumn(name = "IdPerfil")
    private Perfil perfil;

    public EnlacePerfil() {
    }

    public EnlacePerfil(int idEnlace, String tipo, String URL, Perfil perfil) {
        IdEnlace = idEnlace;
        this.tipo = tipo;
        this.URL = URL;
        this.perfil = perfil;
    }

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
