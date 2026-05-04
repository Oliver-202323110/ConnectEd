package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.ChatParticipante;
import pe.edu.upc.connected.repositories.IChatParticipanteRepository;
import pe.edu.upc.connected.servicesinterfaces.IChatParticipanteService;

import java.util.List;

@Service
public class ChatParticipanteServiceImplement implements IChatParticipanteService {

    @Autowired
    private IChatParticipanteRepository chatParticipanteRepositorio;

    @Override
    public List<ChatParticipante> list() {
        return chatParticipanteRepositorio.findAll();
    }

    @Override
    public ChatParticipante save(ChatParticipante chatParticipante) {
        return chatParticipanteRepositorio.save(chatParticipante);
    }

    @Override
    public ChatParticipante findById(int id) {
        return chatParticipanteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        chatParticipanteRepositorio.deleteById(id);
    }

    @Override
    public List<ChatParticipante> listarParticipantesPorChat(int idChat) {
        return chatParticipanteRepositorio.listarParticipantesPorChat(idChat);
    }

    @Override
    public List<ChatParticipante> listarChatsPorUsuario(int idUsuario) {
        return chatParticipanteRepositorio.listarChatsPorUsuario(idUsuario);
    }
}
