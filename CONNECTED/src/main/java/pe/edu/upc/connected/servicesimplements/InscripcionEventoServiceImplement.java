package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.InscripcionEvento;
import pe.edu.upc.connected.repositories.IInscripcionEventoRepository;
import pe.edu.upc.connected.servicesinterfaces.IInscripcionEventoService;

import java.util.List;

@Service
public class InscripcionEventoServiceImplement implements IInscripcionEventoService {

    @Autowired
    private IInscripcionEventoRepository InscripcionEventoRepositorio;

    @Override
    public List<InscripcionEvento> list() { return InscripcionEventoRepositorio.findAll(); }

    @Override
    public InscripcionEvento save(InscripcionEvento inscripcion) { return InscripcionEventoRepositorio.save(inscripcion); }

    @Override
    public InscripcionEvento findById(int id) { return InscripcionEventoRepositorio.findById(id).orElse(null); }

    @Override
    public void delete(int id) { InscripcionEventoRepositorio.deleteById(id); }
}