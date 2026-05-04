package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.MensajeGeneralDTO;
import pe.edu.upc.connected.entities.Mensaje;
import pe.edu.upc.connected.servicesinterfaces.IMensajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private IMensajeService mensajeServicio;

    // US09 - Iniciar un chat con un contacto
    @GetMapping("/listarMensajes")
    public ResponseEntity<List<MensajeGeneralDTO>> listarMensajes() {
        ModelMapper m = new ModelMapper();
        List<MensajeGeneralDTO> listaMensajes = mensajeServicio.list().stream()
                .map(y -> m.map(y, MensajeGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaMensajes);
    }

    @GetMapping("/buscarMensaje/{id}")
    public ResponseEntity<MensajeGeneralDTO> buscarMensaje(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Mensaje mensaje = mensajeServicio.findById(id);
        if (mensaje == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(m.map(mensaje, MensajeGeneralDTO.class));
    }

    // US09 - Enviar un mensaje dentro de un chat
    @PostMapping("/guardarMensaje")
    public ResponseEntity<Mensaje> guardarMensaje(@RequestBody Mensaje mensaje) {
        return ResponseEntity.ok(mensajeServicio.save(mensaje));
    }

    @PutMapping("/actualizarMensaje/{id}")
    public ResponseEntity<Mensaje> actualizarMensaje(@PathVariable int id, @RequestBody Mensaje mensaje) {
        mensaje.setIdMensaje(id);
        return ResponseEntity.ok(mensajeServicio.save(mensaje));
    }

    @DeleteMapping("/eliminarMensaje/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable int id) {
        mensajeServicio.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarMensajesPorChat/{idChat}")
    public ResponseEntity<List<MensajeGeneralDTO>> listarMensajesPorChat(@PathVariable int idChat) {
        ModelMapper m = new ModelMapper();
        List<MensajeGeneralDTO> lista = mensajeServicio.listarMensajesPorChat(idChat).stream()
                .map(y -> m.map(y, MensajeGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listarMensajesNoLeidosPorUsuario/{idUsuario}")
    public ResponseEntity<List<MensajeGeneralDTO>> listarMensajesNoLeidosPorUsuario(@PathVariable int idUsuario) {
        ModelMapper m = new ModelMapper();
        List<MensajeGeneralDTO> lista = mensajeServicio.listarMensajesNoLeidosPorUsuario(idUsuario).stream()
                .map(y -> m.map(y, MensajeGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
