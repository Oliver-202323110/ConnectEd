package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.ChatParticipante;

import java.util.List;

public interface IChatParticipanteService {
    List<ChatParticipante> list();
    ChatParticipante save(ChatParticipante chatParticipante);
    ChatParticipante findById(int id);
    void delete(int id);
    List<ChatParticipante> listarParticipantesPorChat(int idChat);
    List<ChatParticipante> listarChatsPorUsuario(int idUsuario);
}
