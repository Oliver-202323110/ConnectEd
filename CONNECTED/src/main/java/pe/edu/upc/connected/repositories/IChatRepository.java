package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Chat;

import java.util.List;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Integer> {

    //Listar chats por estado (activo, inactivo, etc.)
    @Query(value = "SELECT * FROM chat WHERE estado = :estado", nativeQuery = true)
    List<Chat> listarChatsPorEstado(@Param("estado") String estado);

    //Listar chats por tipo (individual, grupal, videollamada)
    @Query(value = "SELECT * FROM chat WHERE tipo = :tipo", nativeQuery = true)
    List<Chat> listarChatsPorTipo(@Param("tipo") String tipo);
}
