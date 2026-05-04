package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.InscripcionEvento;
import java.util.List;

public interface IInscripcionEventoService {
    List<InscripcionEvento> list();
    InscripcionEvento save(InscripcionEvento inscripcion);
    InscripcionEvento findById(int id);
    void delete(int id);
}