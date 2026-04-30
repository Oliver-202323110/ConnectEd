package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Evento;
import java.util.List;

public interface IEventoService {
    List<Evento> list();
    Evento save(Evento evento);
    Evento findById(int id);
    void delete(int id);
}