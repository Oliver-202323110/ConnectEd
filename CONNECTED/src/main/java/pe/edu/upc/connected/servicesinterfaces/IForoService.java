package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IForoService {
    public List<Foro> list();
    public Optional<Foro> listId(int id);
    public Foro insert(Foro f);
    public void update(Foro fU);
    public void delete(int id);
}
