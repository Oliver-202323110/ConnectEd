package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.repositories.IForoRepository;
import pe.edu.upc.connected.servicesinterfaces.IForoService;

import java.awt.*;
import java.util.List;

@Service
public class ForoServiceImplement implements IForoService {

    @Autowired
    private IForoRepository foroRepositorio;


    @Override
    public List<Foro> list() {
        return foroRepositorio.findAll();
    }
}
