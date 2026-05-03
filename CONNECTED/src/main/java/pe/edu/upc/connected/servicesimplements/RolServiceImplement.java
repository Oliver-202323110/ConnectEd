package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Rol;
import pe.edu.upc.connected.repositories.IRolRepository;
import pe.edu.upc.connected.servicesinterfaces.IRolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rolRepositorio;


    @Override
    public List<Rol> list() {
        return rolRepositorio.findAll();
    }

    @Override
    public Rol insert(Rol r) {
        return rolRepositorio.save(r);
    }

    @Override
    public Optional<Rol> listId(int id) {
        return rolRepositorio.findById(id);
    }
}
