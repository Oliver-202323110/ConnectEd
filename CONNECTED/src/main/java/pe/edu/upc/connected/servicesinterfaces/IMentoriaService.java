package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Mentoria;
import pe.edu.upc.connected.entities.Publicacion;

import java.util.List;
import java.util.Optional;

public interface IMentoriaService {
    public List<Mentoria> list();
    public Mentoria insert(Mentoria m);
    public Optional<Mentoria> listId(int id);
    public void update(Mentoria m);
    public void delete(int id);
}
