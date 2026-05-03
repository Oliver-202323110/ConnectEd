package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.GrupoMiembro;
import pe.edu.upc.connected.repositories.IGrupoMiembroRepository;
import pe.edu.upc.connected.servicesinterfaces.IGrupoMiembroService;

import java.util.List;

@Service
public class GrupoMiembroServiceImplement implements IGrupoMiembroService {

    @Autowired
    private IGrupoMiembroRepository grupoMiembroRepositorio;

    @Override
    public List<GrupoMiembro> list() {
        return grupoMiembroRepositorio.findAll();
    }
}
