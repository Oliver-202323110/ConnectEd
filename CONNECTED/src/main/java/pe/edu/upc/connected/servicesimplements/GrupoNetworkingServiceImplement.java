package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.connected.entities.GrupoNetworking;
import pe.edu.upc.connected.repositories.IGrupoNetworkingRepository;
import pe.edu.upc.connected.servicesinterfaces.IGrupoNetworkingService;

import java.util.List;

public class GrupoNetworkingServiceImplement implements IGrupoNetworkingService {

    @Autowired
    private IGrupoNetworkingRepository grupoNetworkingRepositorio;


    @Override
    public List<GrupoNetworking> list() {
        return grupoNetworkingRepositorio.findAll();
    }
}
