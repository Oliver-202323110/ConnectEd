package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ChatGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChatController {

    @Autowired
    private IChatService chatServicio;

    @GetMapping("/listarChats")
    public ResponseEntity<List<ChatGeneralDTO>> listarChats() {
        ModelMapper m = new ModelMapper();
        List<ChatGeneralDTO> listaChats = chatServicio.list().stream()
                .map(y -> m.map(y, ChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaChats);
    }
}
