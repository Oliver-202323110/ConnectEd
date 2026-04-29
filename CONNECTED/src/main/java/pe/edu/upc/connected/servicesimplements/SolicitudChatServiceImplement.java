package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.SolicitudChat;
import pe.edu.upc.connected.repositories.ISolicitudChatRepository;
import pe.edu.upc.connected.servicesinterfaces.ISolicitudChatService;

import java.util.List;

@Service
public class SolicitudChatServiceImplement implements ISolicitudChatService {

    @Autowired
    private ISolicitudChatRepository solicitudChatRepositorio;

    @Override
    public List<SolicitudChat> list() {
        return solicitudChatRepositorio.findAll();
    }
}
