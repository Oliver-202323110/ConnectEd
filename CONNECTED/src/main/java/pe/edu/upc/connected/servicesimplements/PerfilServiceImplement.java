package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Perfil;
import pe.edu.upc.connected.repositories.IPerfilRepository;
import pe.edu.upc.connected.servicesinterfaces.IPerfilService;

import java.util.List;

@Service
public class PerfilServiceImplement implements IPerfilService {

    @Autowired
    private IPerfilRepository perfilRepositorio;


    @Override
    public List<Perfil> list() {
        return perfilRepositorio.findAll();
    }
}
