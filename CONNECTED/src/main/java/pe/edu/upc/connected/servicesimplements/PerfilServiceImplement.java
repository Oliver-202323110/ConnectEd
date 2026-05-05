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
    private IPerfilRepository pR;


    @Override
    public List<Perfil> list() {
        return pR.findAll();
    }

    @Override
    public Perfil insert(Perfil p) {
        return pR.save(p);
    }


}
