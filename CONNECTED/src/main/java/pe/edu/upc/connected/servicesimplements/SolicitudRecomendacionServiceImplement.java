package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.SolicitudRecomendacion;
import pe.edu.upc.connected.repositories.ISolicitudRecomendacionRepository;
import pe.edu.upc.connected.servicesinterfaces.ISolicitudRecomendacionService;

import java.util.List;

@Service
public class SolicitudRecomendacionServiceImplement implements ISolicitudRecomendacionService {

    @Autowired
    private ISolicitudRecomendacionRepository SolicitudRecomendacionRepositorio;

    @Override
    public List<SolicitudRecomendacion> list() { return SolicitudRecomendacionRepositorio.findAll(); }

    @Override
    public SolicitudRecomendacion save(SolicitudRecomendacion solicitud) { return SolicitudRecomendacionRepositorio.save(solicitud); }

    @Override
    public SolicitudRecomendacion findById(int id) { return SolicitudRecomendacionRepositorio.findById(id).orElse(null); }

    @Override
    public void delete(int id) { SolicitudRecomendacionRepositorio.deleteById(id); }
}