package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario,Integer> {

    //Buscar usuario por correo
    @Query(value = "SELECT * FROM usuario WHERE correo = :correo", nativeQuery = true)
    Optional<Usuario> buscarPorCorreo(@Param("correo") String correo);

    //Contar usuarios por rol
    @Query(value = "SELECT count(*) FROM usuario u JOIN rol r ON u.id_rol = r.id_rol WHERE r.nombre_rol = :nombreRol", nativeQuery = true)
    Integer contarUsuariosPorNombreRol(@Param("nombreRol") String nombreRol);

    //Buscar usuarios registrados en un rango de fechas
    @Query(value = "SELECT * FROM usuario WHERE fecha_registro BETWEEN :inicio AND :fin", nativeQuery = true)
    List<Usuario> buscarUsuariosPorRangoFecha(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    //Cantidad de usuarios por estado de cuenta
    @Query(value = "SELECT estado_cuenta, COUNT(*) FROM usuario GROUP BY estado_cuenta", nativeQuery = true)
    List<Object[]> contarUsuariosPorEstadoCuenta();

}
