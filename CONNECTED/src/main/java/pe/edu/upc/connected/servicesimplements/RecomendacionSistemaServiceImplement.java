package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.connected.entities.RecomendacionSistema;
import pe.edu.upc.connected.repositories.IRecomendacionSistemaRepository;
import pe.edu.upc.connected.servicesinterfaces.IRecomendacionSistemaService;

import java.util.List;

public class RecomendacionSistemaServiceImplement implements IRecomendacionSistemaService {

    @Autowired
    private IRecomendacionSistemaRepository recomendacionSistemaRepositorio;


    @Override
    public List<RecomendacionSistema> list() {
        return recomendacionSistemaRepositorio.findAll();
    }
}
