package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Publicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPublicacionService {
    public List<Publicacion> list();
    public Publicacion insert(Publicacion p);
    public Optional<Publicacion> listId(int id);
    public void update(Publicacion p);
    public void delete(int id);
    public List<Publicacion> buscarPorRangoDeFechas(LocalDate f1, LocalDate f2);
    public int countPublicacionesByUserId(int id);
}
