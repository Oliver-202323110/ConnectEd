package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.UsuarioSeguidor;
import java.util.List;

public interface IUsuarioSeguidorService {
    List<UsuarioSeguidor> list();
    UsuarioSeguidor save(UsuarioSeguidor usuarioSeguidor);
    UsuarioSeguidor findById(int id);
    void delete(int id);
}