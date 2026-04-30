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
}
