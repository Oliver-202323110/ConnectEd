package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Chat;

import java.util.List;

public interface IChatService {
    List<Chat> list();
    Chat save(Chat chat);
    Chat findById(int id);
    void delete(int id);
    List<Chat> listarPorEstado(String estado);
    List<Chat> listarPorTipo(String tipo);
}
