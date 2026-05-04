package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.ChatParticipante;

import java.util.List;

@Repository
public interface IChatParticipanteRepository extends JpaRepository<ChatParticipante, Integer> {

    //Listar todos los participantes de un chat específico
    @Query(value = "SELECT * FROM chat_participante WHERE id_chat = :idChat", nativeQuery = true)
    List<ChatParticipante> listarParticipantesPorChat(@Param("idChat") int idChat);

    //Listar todos los chats en los que participa un usuario
    @Query(value = "SELECT * FROM chat_participante WHERE id_usuario = :idUsuario", nativeQuery = true)
    List<ChatParticipante> listarChatsPorUsuario(@Param("idUsuario") int idUsuario);
}
