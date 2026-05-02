package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.CalificacionMentoria;
import pe.edu.upc.connected.entities.Mentoria;

import java.util.List;
import java.util.Optional;

public interface ICalificacionMentoriaService {
    public List<CalificacionMentoria> list();
    public CalificacionMentoria insert(CalificacionMentoria c);
    public Optional<CalificacionMentoria> listId(int id);
    public void update(CalificacionMentoria c);
    public void delete(int id);
}
