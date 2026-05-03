package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.RecursoProfesional;
import pe.edu.upc.connected.repositories.IRecursoProfesionalRepository;
import pe.edu.upc.connected.servicesinterfaces.IRecursoProfesionalService;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoProfesionalImplement implements IRecursoProfesionalService {
    @Autowired
    private IRecursoProfesionalRepository rR;
    @Override
    public List<RecursoProfesional> list() {
        return rR.findAll();
    }

    @Override
    public RecursoProfesional insert(RecursoProfesional r) {
        return rR.save(r);
    }

    @Override
    public Optional<RecursoProfesional> listId(int id) {
        return rR.findById(id);
    }

    @Override
    public void update(RecursoProfesional r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }
}
