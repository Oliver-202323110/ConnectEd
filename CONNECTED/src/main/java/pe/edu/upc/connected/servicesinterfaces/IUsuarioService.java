package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> list();
    public Usuario insert(Usuario u);
    public Optional<Usuario> listId(int id);
    public void update(Usuario u);
    public void delete(int id);
    List<Object[]> buscarNativeQuery();
}
