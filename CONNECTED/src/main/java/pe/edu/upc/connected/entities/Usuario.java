package pe.edu.upc.connected.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUsuario;

    @Column(name = "nombres",length =50 ,nullable =false )
    private String nombres;
    @Column(name = "apellidoPaterno",length =50 ,nullable =false )
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno",length =50 ,nullable =false )
    private String apellidoMaterno;
    @Column(name = "correo",length =50 ,nullable =false )
    private String correo;
    @Column(name = "contraseña",length =50 ,nullable =false )
    private String contraseña;
    @Column(name = "estadoCuenta",length =50 ,nullable =false )
    private String estadoCuenta;
    @Column(name = "fechaRegistro" ,nullable =false )
    private LocalDate fechaRegistro;
    @Column(name = "ultimaSesion" ,nullable =false )
    private LocalDate ultimaSesion;
    @Id
    private int IdRol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contraseña, String estadoCuenta, LocalDate fechaRegistro, LocalDate ultimaSesion, int idRol) {
        IdUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contraseña = contraseña;
        this.estadoCuenta = estadoCuenta;
        this.fechaRegistro = fechaRegistro;
        this.ultimaSesion = ultimaSesion;
        IdRol = idRol;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(LocalDate ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int idRol) {
        IdRol = idRol;
    }
}
