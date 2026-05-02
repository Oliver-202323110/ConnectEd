package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.SolicitudChatGeneralDTO;
import pe.edu.upc.connected.entities.SolicitudChat;
import pe.edu.upc.connected.servicesinterfaces.ISolicitudChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/solicitudesChat")
public class SolicitudChatController {

    @Autowired
    private ISolicitudChatService solicitudChatServicio;

    // US28 - Aceptar chats con personas | US29 - Enviar invitación para chatear
    @GetMapping("/listarSolicitudesChat")
    public ResponseEntity<List<SolicitudChatGeneralDTO>> listarSolicitudesChat() {
        ModelMapper m = new ModelMapper();
        List<SolicitudChatGeneralDTO> listaSolicitudesChat = solicitudChatServicio.list().stream()
                .map(y -> m.map(y, SolicitudChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaSolicitudesChat);
    }

    @GetMapping("/buscarSolicitudChat/{id}")
    public ResponseEntity<SolicitudChatGeneralDTO> buscarSolicitudChat(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        SolicitudChat solicitudChat = solicitudChatServicio.findById(id);
        if (solicitudChat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(m.map(solicitudChat, SolicitudChatGeneralDTO.class));
    }

    // US29 - Enviar invitación para chatear
    @PostMapping("/guardarSolicitudChat")
    public ResponseEntity<SolicitudChat> guardarSolicitudChat(@RequestBody SolicitudChat solicitudChat) {
        return ResponseEntity.ok(solicitudChatServicio.save(solicitudChat));
    }

    // US28 - Aceptar o rechazar solicitud de chat (actualizar estado)
    @PutMapping("/actualizarSolicitudChat/{id}")
    public ResponseEntity<SolicitudChat> actualizarSolicitudChat(@PathVariable int id, @RequestBody SolicitudChat solicitudChat) {
        solicitudChat.setIdSolicitudChat(id);
        return ResponseEntity.ok(solicitudChatServicio.save(solicitudChat));
    }

    @DeleteMapping("/eliminarSolicitudChat/{id}")
    public ResponseEntity<Void> eliminarSolicitudChat(@PathVariable int id) {
        solicitudChatServicio.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarSolicitudesPorEstado/{estado}")
    public ResponseEntity<List<SolicitudChatGeneralDTO>> listarSolicitudesPorEstado(@PathVariable String estado) {
        ModelMapper m = new ModelMapper();
        List<SolicitudChatGeneralDTO> lista = solicitudChatServicio.listarPorEstado(estado).stream()
                .map(y -> m.map(y, SolicitudChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listarSolicitudesPorUsuario/{idUsuario}")
    public ResponseEntity<List<SolicitudChatGeneralDTO>> listarSolicitudesPorUsuario(@PathVariable int idUsuario) {
        ModelMapper m = new ModelMapper();
        List<SolicitudChatGeneralDTO> lista = solicitudChatServicio.listarPorUsuario(idUsuario).stream()
                .map(y -> m.map(y, SolicitudChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
