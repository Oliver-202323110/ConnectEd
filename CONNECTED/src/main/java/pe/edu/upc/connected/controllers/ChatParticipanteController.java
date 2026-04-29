package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ChatParticipanteGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IChatParticipanteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChatParticipanteController {

    @Autowired
    private IChatParticipanteService chatParticipanteServicio;

    @GetMapping("/listarChatParticipantes")
    public ResponseEntity<List<ChatParticipanteGeneralDTO>> listarChatParticipantes() {
        ModelMapper m = new ModelMapper();
        List<ChatParticipanteGeneralDTO> listaChatParticipantes = chatParticipanteServicio.list().stream()
                .map(y -> m.map(y, ChatParticipanteGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaChatParticipantes);
    }
}
