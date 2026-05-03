package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.connected.entities.GrupoNetworking;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class GrupoMiembroGeneralDTO {
    private int IdGrupoMiembro;
    private String rolGrupo;
    private LocalDate fechaUnion;
    private GrupoNetworking grupoNetworking;
    private Usuario usuario;

    public int getIdGrupoMiembro() {
        return IdGrupoMiembro;
    }

    public void setIdGrupoMiembro(int idGrupoMiembro) {
        IdGrupoMiembro = idGrupoMiembro;
    }

    public String getRolGrupo() {
        return rolGrupo;
    }

    public void setRolGrupo(String rolGrupo) {
        this.rolGrupo = rolGrupo;
    }

    public LocalDate getFechaUnion() {
        return fechaUnion;
    }

    public void setFechaUnion(LocalDate fechaUnion) {
        this.fechaUnion = fechaUnion;
    }

    public GrupoNetworking getGrupoNetworking() {
        return grupoNetworking;
    }

    public void setGrupoNetworking(GrupoNetworking grupoNetworking) {
        this.grupoNetworking = grupoNetworking;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
