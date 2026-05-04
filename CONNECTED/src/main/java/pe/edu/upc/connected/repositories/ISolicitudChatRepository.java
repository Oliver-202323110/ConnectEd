package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.SolicitudChat;

import java.util.List;

@Repository
public interface ISolicitudChatRepository extends JpaRepository<SolicitudChat, Integer> {

    //Listar solicitudes de chat por estado (pendiente, aceptado, rechazado)
    @Query(value = "SELECT * FROM solicitud_chat WHERE estado = :estado", nativeQuery = true)
    List<SolicitudChat> listarSolicitudesPorEstado(@Param("estado") String estado);

    //Listar todas las solicitudes enviadas por un usuario
    @Query(value = "SELECT * FROM solicitud_chat WHERE id_usuario = :idUsuario", nativeQuery = true)
    List<SolicitudChat> listarSolicitudesPorUsuario(@Param("idUsuario") int idUsuario);
}
