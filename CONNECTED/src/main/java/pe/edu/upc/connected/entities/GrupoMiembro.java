package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "GrupoMiembro")
public class GrupoMiembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdGrupoMiembro;

    @Column(name = "rolGrupo", length = 50, nullable = false)
    private String rolGrupo;

    @Column(name = "fechaUnion", nullable = false)
    private LocalDate fechaUnion;

    @ManyToOne
    @JoinColumn(name = "IdGrupo")
    private GrupoNetworking grupoNetworking;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;

    public GrupoMiembro() {
    }

    public GrupoMiembro(int idGrupoMiembro, String rolGrupo, LocalDate fechaUnion, GrupoNetworking grupoNetworking, Usuario usuario) {
        IdGrupoMiembro = idGrupoMiembro;
        this.rolGrupo = rolGrupo;
        this.fechaUnion = fechaUnion;
        this.grupoNetworking = grupoNetworking;
        this.usuario = usuario;
    }

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
