package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    List<Mensaje> list();
    Mensaje save(Mensaje mensaje);
    Mensaje findById(int id);
    void delete(int id);
    List<Mensaje> listarMensajesPorChat(int idChat);
    List<Mensaje> listarMensajesNoLeidosPorUsuario(int idUsuario);
}
