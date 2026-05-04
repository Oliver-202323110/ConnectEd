package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public Usuario insert(Usuario u);
    public void update(Usuario u);
}
