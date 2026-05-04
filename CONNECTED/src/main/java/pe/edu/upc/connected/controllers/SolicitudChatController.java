package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.SolicitudChatGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.ISolicitudChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SolicitudChatController {

    @Autowired
    private ISolicitudChatService solicitudChatServicio;

    @GetMapping("/listarSolicitudesChat")
    public ResponseEntity<List<SolicitudChatGeneralDTO>> listarSolicitudesChat() {
        ModelMapper m = new ModelMapper();
        List<SolicitudChatGeneralDTO> listaSolicitudesChat = solicitudChatServicio.list().stream()
                .map(y -> m.map(y, SolicitudChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaSolicitudesChat);
    }
}
