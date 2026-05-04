package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    public List<Rol> list();
    public Rol insert(Rol r);
    public Optional<Rol> listId(int id);
}
