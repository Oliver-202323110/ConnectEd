package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.MensajeGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IMensajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MensajeController {

    @Autowired
    private IMensajeService mensajeServicio;

    @GetMapping("/listarMensajes")
    public ResponseEntity<List<MensajeGeneralDTO>> listarMensajes() {
        ModelMapper m = new ModelMapper();
        List<MensajeGeneralDTO> listaMensajes = mensajeServicio.list().stream()
                .map(y -> m.map(y, MensajeGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaMensajes);
    }
}
