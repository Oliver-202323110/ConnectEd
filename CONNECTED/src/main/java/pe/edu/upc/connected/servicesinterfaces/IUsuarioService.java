package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> list();
    public Optional<Usuario> listId(int id);
}
