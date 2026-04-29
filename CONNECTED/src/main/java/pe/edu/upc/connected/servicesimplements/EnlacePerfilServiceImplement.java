package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.EnlacePerfil;
import pe.edu.upc.connected.repositories.IEnlacePerfilRepository;
import pe.edu.upc.connected.servicesinterfaces.IEnlacePerfilService;

import java.util.List;

@Service
public class EnlacePerfilServiceImplement implements IEnlacePerfilService {

    @Autowired
    private IEnlacePerfilRepository enlacePerfilRepositorio;


    @Override
    public List<EnlacePerfil> list() {
        return enlacePerfilRepositorio.findAll();
    }
}
