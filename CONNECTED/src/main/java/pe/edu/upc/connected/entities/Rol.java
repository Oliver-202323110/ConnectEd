package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRol;

    @Column(name = "nombreRol", length = 50, nullable =false )
    private String nombreRol;

    public Rol() {
    }

    public Rol(int idRol, String nombreRol) {
        IdRol = idRol;
        this.nombreRol = nombreRol;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int idRol) {
        IdRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
