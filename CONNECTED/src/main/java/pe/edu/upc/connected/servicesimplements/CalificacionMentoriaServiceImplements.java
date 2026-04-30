package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.CalificacionMentoria;
import pe.edu.upc.connected.repositories.ICalificacionMentoriaRepository;
import pe.edu.upc.connected.servicesinterfaces.ICalificacionMentoriaService;

import java.util.List;

@Service
public class CalificacionMentoriaServiceImplements implements ICalificacionMentoriaService {
    @Autowired
    private ICalificacionMentoriaRepository cR;
    @Override
    public List<CalificacionMentoria> list() {
        return cR.findAll();
    }
}
