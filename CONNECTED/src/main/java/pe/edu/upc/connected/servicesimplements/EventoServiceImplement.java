package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Evento;
import pe.edu.upc.connected.repositories.IEventoRepository;
import pe.edu.upc.connected.servicesinterfaces.IEventoService;

import java.util.List;

@Service
public class EventoServiceImplement implements IEventoService {

    @Autowired
    private IEventoRepository EventoRepositorio;

    @Override
    public List<Evento> list() { return EventoRepositorio.findAll(); }

    @Override
    public Evento save(Evento evento) { return EventoRepositorio.save(evento); }

    @Override
    public Evento findById(int id) { return EventoRepositorio.findById(id).orElse(null); }

    @Override
    public void delete(int id) { EventoRepositorio.deleteById(id); }
}