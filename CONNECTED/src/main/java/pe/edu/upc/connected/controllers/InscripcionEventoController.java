package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.InscripcionEventoListDTO;
import pe.edu.upc.connected.entities.InscripcionEvento;
import pe.edu.upc.connected.servicesinterfaces.IInscripcionEventoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionEventoController {

    @Autowired
    private IInscripcionEventoService inscripcionServicio;

    @GetMapping("/listarInscripciones")
    public ResponseEntity<List<InscripcionEventoListDTO>> listarInscripciones() {
        ModelMapper m = new ModelMapper();
        List<InscripcionEventoListDTO> lista = inscripcionServicio.list().stream()
                .map(i -> m.map(i, InscripcionEventoListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/guardarInscripcion")
    public ResponseEntity<InscripcionEvento> guardarInscripcion(@RequestBody InscripcionEvento inscripcion) {
        return ResponseEntity.ok(inscripcionServicio.save(inscripcion));
    }

    @PutMapping("/actualizarInscripcion/{id}")
    public ResponseEntity<InscripcionEvento> actualizarInscripcion(@PathVariable int id, @RequestBody InscripcionEvento inscripcion) {
        inscripcion.setIdInscripcion(id);
        return ResponseEntity.ok(inscripcionServicio.save(inscripcion));
    }

    @DeleteMapping("/eliminarInscripcion/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable int id) {
        inscripcionServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}