package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Perfil;

import java.util.List;

public interface IPerfilService {
    public List<Perfil> list();
    public Perfil insert(Perfil p);
}
