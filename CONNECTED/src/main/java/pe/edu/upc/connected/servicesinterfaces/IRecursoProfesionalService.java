package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.RecursoProfesional;

import java.util.List;
import java.util.Optional;

public interface IRecursoProfesionalService {
    public List<RecursoProfesional> list();
    public RecursoProfesional insert(RecursoProfesional r);
    public Optional<RecursoProfesional> listId(int id);
    public void update(RecursoProfesional r);
    public void delete(int id);
}
