package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Publicacion;
import pe.edu.upc.connected.repositories.IPublicacionRepository;
import pe.edu.upc.connected.servicesinterfaces.IPublicacionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServiceImplement implements IPublicacionService {
    @Autowired
    private IPublicacionRepository pR;

    @Override
    public List<Publicacion> list() {
        return pR.findAll();
    }

    @Override
    public Publicacion insert(Publicacion p) {
        return pR.save(p);
    }

    @Override
    public Optional<Publicacion> listId(int id) {
        return pR.findById(id);
    }

    @Override
    public void update(Publicacion p) {
        pR.save(p);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public List<Publicacion> buscarPorRangoDeFechas(LocalDate f1, LocalDate f2) {
        return pR.buscarPorRangoDeFechas(f1, f2);
    }

    @Override
    public List<Object[]> countPublicacionesByUser() {
        return pR.countPublicacionesByUser();
    }
}
