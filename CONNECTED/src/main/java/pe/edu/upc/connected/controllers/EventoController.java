package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.EventoListDTO;
import pe.edu.upc.connected.entities.Evento;
import pe.edu.upc.connected.servicesinterfaces.IEventoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private IEventoService eventoServicio;

    @GetMapping("/listarEventos")
    public ResponseEntity<List<EventoListDTO>> listarEventos() {
        ModelMapper m = new ModelMapper();
        List<EventoListDTO> lista = eventoServicio.list().stream()
                .map(e -> m.map(e, EventoListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/guardarEvento")
    public ResponseEntity<Evento> guardarEvento(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoServicio.save(evento));
    }

    @PutMapping("/actualizarEvento/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable int id, @RequestBody Evento evento) {
        evento.setIdEvento(id);
        return ResponseEntity.ok(eventoServicio.save(evento));
    }

    @DeleteMapping("/eliminarEvento/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable int id) {
        eventoServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}