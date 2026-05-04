package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Mensaje;

import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {

    //Listar todos los mensajes de un chat específico
    @Query(value = "SELECT * FROM mensaje WHERE id_chat = :idChat", nativeQuery = true)
    List<Mensaje> listarMensajesPorChat(@Param("idChat") int idChat);

    //Listar mensajes no leídos de un usuario
    @Query(value = "SELECT * FROM mensaje WHERE id_usuario = :idUsuario AND leido = false", nativeQuery = true)
    List<Mensaje> listarMensajesNoLeidosPorUsuario(@Param("idUsuario") int idUsuario);
}
