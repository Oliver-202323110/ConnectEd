package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.ForoParticipante;
import pe.edu.upc.connected.repositories.IForoParticipanteRepository;
import pe.edu.upc.connected.servicesinterfaces.IForoParticipanteService;

import java.util.List;

@Service
public class ForoParticipanteServiceImplement implements IForoParticipanteService {

    @Autowired
    private IForoParticipanteRepository foroParticipanteRepositorio;

    @Override
    public List<ForoParticipante> list() {
        return foroParticipanteRepositorio.findAll();
    }
}
