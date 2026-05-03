package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.SolicitudRecomendacionListDTO;
import pe.edu.upc.connected.entities.SolicitudRecomendacion;
import pe.edu.upc.connected.servicesinterfaces.ISolicitudRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudRecomendacionController {

    @Autowired
    private ISolicitudRecomendacionService solicitudServicio;

    @GetMapping("/listarSolicitudes")
    public ResponseEntity<List<SolicitudRecomendacionListDTO>> listarSolicitudes() {
        ModelMapper m = new ModelMapper();
        List<SolicitudRecomendacionListDTO> lista = solicitudServicio.list().stream()
                .map(s -> m.map(s, SolicitudRecomendacionListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/guardarSolicitud")
    public ResponseEntity<SolicitudRecomendacion> guardarSolicitud(@RequestBody SolicitudRecomendacion solicitud) {
        return ResponseEntity.ok(solicitudServicio.save(solicitud));
    }

    @PutMapping("/actualizarSolicitud/{id}")
    public ResponseEntity<SolicitudRecomendacion> actualizarSolicitud(@PathVariable int id, @RequestBody SolicitudRecomendacion solicitud) {
        solicitud.setIdSolicitud(id);
        return ResponseEntity.ok(solicitudServicio.save(solicitud));
    }

    @DeleteMapping("/eliminarSolicitud/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable int id) {
        solicitudServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}