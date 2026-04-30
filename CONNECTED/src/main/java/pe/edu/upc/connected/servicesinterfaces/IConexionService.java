package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.Conexion;
import java.util.List;

public interface IConexionService {
    List<Conexion> list();
    Conexion save(Conexion conexion);
    Conexion findById(int id);
    void delete(int id);
}