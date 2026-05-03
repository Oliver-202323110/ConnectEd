package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.entities.TemaForo;
import pe.edu.upc.connected.repositories.ITemaForoRepository;
import pe.edu.upc.connected.servicesinterfaces.IForoService;
import pe.edu.upc.connected.servicesinterfaces.ITemaForoService;

import java.util.List;

@Service
public class TemaForoServiceImplement implements ITemaForoService {

    @Autowired
    private ITemaForoRepository temaForoRepositorio;


    @Override
    public List<TemaForo> list() {
        return temaForoRepositorio.findAll();
    }
}
