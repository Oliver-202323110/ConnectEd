package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.ChatParticipanteGeneralDTO;
import pe.edu.upc.connected.entities.ChatParticipante;
import pe.edu.upc.connected.servicesinterfaces.IChatParticipanteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chatParticipantes")
public class ChatParticipanteController {

    @Autowired
    private IChatParticipanteService chatParticipanteServicio;

    // US23 - Revisión de conexiones profesionales | US04 - Añadir contactos
    @GetMapping("/listarChatParticipantes")
    public ResponseEntity<List<ChatParticipanteGeneralDTO>> listarChatParticipantes() {
        ModelMapper m = new ModelMapper();
        List<ChatParticipanteGeneralDTO> listaChatParticipantes = chatParticipanteServicio.list().stream()
                .map(y -> m.map(y, ChatParticipanteGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaChatParticipantes);
    }

    @GetMapping("/buscarChatParticipante/{id}")
    public ResponseEntity<ChatParticipanteGeneralDTO> buscarChatParticipante(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        ChatParticipante chatParticipante = chatParticipanteServicio.findById(id);
        if (chatParticipante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(m.map(chatParticipante, ChatParticipanteGeneralDTO.class));
    }

    // US04 - Añadir contactos a mi red profesional | US08 - Videollamada
    @PostMapping("/guardarChatParticipante")
    public ResponseEntity<ChatParticipante> guardarChatParticipante(@RequestBody ChatParticipante chatParticipante) {
        return ResponseEntity.ok(chatParticipanteServicio.save(chatParticipante));
    }

    @PutMapping("/actualizarChatParticipante/{id}")
    public ResponseEntity<ChatParticipante> actualizarChatParticipante(@PathVariable int id, @RequestBody ChatParticipante chatParticipante) {
        chatParticipante.setIdChatParticipante(id);
        return ResponseEntity.ok(chatParticipanteServicio.save(chatParticipante));
    }

    @DeleteMapping("/eliminarChatParticipante/{id}")
    public ResponseEntity<Void> eliminarChatParticipante(@PathVariable int id) {
        chatParticipanteServicio.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarParticipantesPorChat/{idChat}")
    public ResponseEntity<List<ChatParticipanteGeneralDTO>> listarParticipantesPorChat(@PathVariable int idChat) {
        ModelMapper m = new ModelMapper();
        List<ChatParticipanteGeneralDTO> lista = chatParticipanteServicio.listarParticipantesPorChat(idChat).stream()
                .map(y -> m.map(y, ChatParticipanteGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listarChatsPorUsuario/{idUsuario}")
    public ResponseEntity<List<ChatParticipanteGeneralDTO>> listarChatsPorUsuario(@PathVariable int idUsuario) {
        ModelMapper m = new ModelMapper();
        List<ChatParticipanteGeneralDTO> lista = chatParticipanteServicio.listarChatsPorUsuario(idUsuario).stream()
                .map(y -> m.map(y, ChatParticipanteGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
