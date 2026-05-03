package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.SolicitudRecomendacion;
import java.util.List;

public interface ISolicitudRecomendacionService {
    List<SolicitudRecomendacion> list();
    SolicitudRecomendacion save(SolicitudRecomendacion solicitud);
    SolicitudRecomendacion findById(int id);
    void delete(int id);
}