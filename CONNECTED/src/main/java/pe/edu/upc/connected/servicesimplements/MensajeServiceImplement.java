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
}
