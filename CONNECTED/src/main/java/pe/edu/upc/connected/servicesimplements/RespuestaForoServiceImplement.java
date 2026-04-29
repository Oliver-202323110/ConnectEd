package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.RespuestaForo;
import pe.edu.upc.connected.repositories.IRespuestaForoRepository;
import pe.edu.upc.connected.servicesinterfaces.IRespuestaForoService;

import java.util.List;

@Service
public class RespuestaForoServiceImplement implements IRespuestaForoService {

    @Autowired
    private IRespuestaForoRepository respuestaForoRepositorio;

    @Override
    public List<RespuestaForo> list() {
        return respuestaForoRepositorio.findAll();
    }
}
