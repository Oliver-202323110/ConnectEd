package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.repositories.IForoRepository;
import pe.edu.upc.connected.servicesinterfaces.IForoService;

import java.util.List;
import java.util.Optional;

@Service
public class ForoServiceImplement implements IForoService {

    @Autowired
    private IForoRepository fR;


    @Override
    public List<Foro> list() {
        return fR.findAll();
    }

    @Override
    public Optional<Foro> listId(int id) {
        return fR.findById(id);
    }


    @Override
    public Foro insert(Foro f) {
        return fR.save(f);
    }

    @Override
    public void update(Foro fU) {
        fR.save(fU);
    }

    @Override
    public void delete(int id) {
        fR.deleteById(id);
    }


}
