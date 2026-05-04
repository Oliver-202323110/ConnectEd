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
}
