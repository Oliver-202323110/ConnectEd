package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.GrupoMiembro;
import pe.edu.upc.connected.entities.GrupoNetworking;

import java.util.List;

@Repository
public interface IGrupoMiembroRepository extends JpaRepository<GrupoMiembro, Integer> {

    //Listar todos los miembros de un grupo específico
    @Query(value = "SELECT u.nombres, u.apellido_paterno, gm.rol_grupo, gm.fecha_union " +
            "FROM grupo_miembro gm " +
            "JOIN usuario u ON gm.id_usuario = u.id_usuario " +
            "WHERE gm.id_grupo = :idGrupo", nativeQuery = true)
    List<Object[]> listarMiembrosPorGrupo(@Param("idGrupo") int idGrupo);

    //Buscar todos los grupos a los que pertenece un Usuario
    @Query(value = "SELECT gn.* FROM grupo_networking gn " +
            "JOIN grupo_miembro gm ON gn.id_grupo = gm.id_grupo " +
            "WHERE gm.id_usuario = :idUsuario", nativeQuery = true)
    List<GrupoNetworking> buscarGruposPorUsuario(@Param("idUsuario") int idUsuario);

    //Contar cuántos miembros tiene un grupo
    @Query(value = "SELECT count(*) FROM grupo_miembro WHERE id_grupo = :idGrupo", nativeQuery = true)
    Integer contarMiembrosDeUnGrupo(@Param("idGrupo") int idGrupo);
}
