package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.CalificacionMentoria;
import pe.edu.upc.connected.repositories.ICalificacionMentoriaRepository;
import pe.edu.upc.connected.servicesinterfaces.ICalificacionMentoriaService;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionMentoriaServiceImplements implements ICalificacionMentoriaService {
    @Autowired
    private ICalificacionMentoriaRepository cR;
    @Override
    public List<CalificacionMentoria> list() {
        return cR.findAll();
    }

    @Override
    public CalificacionMentoria insert(CalificacionMentoria c) {
        return cR.save(c);
    }

    @Override
    public Optional<CalificacionMentoria> listId(int id) {
        return cR.findById(id);
    }

    @Override
    public void update(CalificacionMentoria c) {
        cR.save(c);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }
}
