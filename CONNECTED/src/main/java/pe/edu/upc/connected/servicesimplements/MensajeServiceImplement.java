package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Mensaje;
import pe.edu.upc.connected.repositories.IMensajeRepository;
import pe.edu.upc.connected.servicesinterfaces.IMensajeService;

import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {

    @Autowired
    private IMensajeRepository mensajeRepositorio;

    @Override
    public List<Mensaje> list() {
        return mensajeRepositorio.findAll();
    }

    @Override
    public Mensaje save(Mensaje mensaje) {
        return mensajeRepositorio.save(mensaje);
    }

    @Override
    public Mensaje findById(int id) {
        return mensajeRepositorio.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        mensajeRepositorio.deleteById(id);
    }

    @Override
    public List<Mensaje> listarMensajesPorChat(int idChat) {
        return mensajeRepositorio.listarMensajesPorChat(idChat);
    }

    @Override
    public List<Mensaje> listarMensajesNoLeidosPorUsuario(int idUsuario) {
        return mensajeRepositorio.listarMensajesNoLeidosPorUsuario(idUsuario);
    }
}
