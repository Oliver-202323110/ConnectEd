package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Chat;
import pe.edu.upc.connected.repositories.IChatRepository;
import pe.edu.upc.connected.servicesinterfaces.IChatService;

import java.util.List;

@Service
public class ChatServiceImplement implements IChatService {

    @Autowired
    private IChatRepository chatRepositorio;

    @Override
    public List<Chat> list() {
        return chatRepositorio.findAll();
    }

    @Override
    public Chat save(Chat chat) {
        return chatRepositorio.save(chat);
    }

    @Override
    public Chat findById(int id) {
        return chatRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        chatRepositorio.deleteById(id);
    }

    @Override
    public List<Chat> listarPorEstado(String estado) {
        return chatRepositorio.listarChatsPorEstado(estado);
    }

    @Override
    public List<Chat> listarPorTipo(String tipo) {
        return chatRepositorio.listarChatsPorTipo(tipo);
    }
}
