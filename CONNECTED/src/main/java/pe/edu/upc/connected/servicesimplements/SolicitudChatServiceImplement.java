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

    @Override
    public SolicitudChat save(SolicitudChat solicitudChat) {
        return solicitudChatRepositorio.save(solicitudChat);
    }

    @Override
    public SolicitudChat findById(int id) {
        return solicitudChatRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        solicitudChatRepositorio.deleteById(id);
    }

    @Override
    public List<SolicitudChat> listarPorEstado(String estado) {
        return solicitudChatRepositorio.listarSolicitudesPorEstado(estado);
    }

    @Override
    public List<SolicitudChat> listarPorUsuario(int idUsuario) {
        return solicitudChatRepositorio.listarSolicitudesPorUsuario(idUsuario);
    }
}
