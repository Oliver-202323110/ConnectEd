package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Conexion;
import pe.edu.upc.connected.repositories.IConexionRepository;
import pe.edu.upc.connected.servicesinterfaces.IConexionService;

import java.util.List;

@Service
public class ConexionServiceImplement implements IConexionService {

    @Autowired
    private IConexionRepository ConexionRepositorio;

    @Override
    public List<Conexion> list() { return ConexionRepositorio.findAll(); }

    @Override
    public Conexion save(Conexion conexion) { return ConexionRepositorio.save(conexion); }

    @Override
    public Conexion findById(int id) { return ConexionRepositorio.findById(id).orElse(null); }

    @Override
    public void delete(int id) { ConexionRepositorio.deleteById(id); }
}