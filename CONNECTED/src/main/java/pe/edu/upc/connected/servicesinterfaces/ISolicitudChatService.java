package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.SolicitudChat;

import java.util.List;

public interface ISolicitudChatService {
    List<SolicitudChat> list();
    SolicitudChat save(SolicitudChat solicitudChat);
    SolicitudChat findById(int id);
    void delete(int id);
    List<SolicitudChat> listarPorEstado(String estado);
    List<SolicitudChat> listarPorUsuario(int idUsuario);
}
