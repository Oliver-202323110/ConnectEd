package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.ChatGeneralDTO;
import pe.edu.upc.connected.entities.Chat;
import pe.edu.upc.connected.servicesinterfaces.IChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private IChatService chatServicio;

    // US09 - Iniciar un chat con un contacto | US08 - Videollamada
    @GetMapping("/listarChats")
    public ResponseEntity<List<ChatGeneralDTO>> listarChats() {
        ModelMapper m = new ModelMapper();
        List<ChatGeneralDTO> listaChats = chatServicio.list().stream()
                .map(y -> m.map(y, ChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaChats);
    }

    @GetMapping("/buscarChat/{id}")
    public ResponseEntity<ChatGeneralDTO> buscarChat(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Chat chat = chatServicio.findById(id);
        if (chat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(m.map(chat, ChatGeneralDTO.class));
    }

    // US09 - Iniciar un chat con un contacto | US08 - Realizar una videollamada
    @PostMapping("/guardarChat")
    public ResponseEntity<Chat> guardarChat(@RequestBody Chat chat) {
        return ResponseEntity.ok(chatServicio.save(chat));
    }

    @PutMapping("/actualizarChat/{id}")
    public ResponseEntity<Chat> actualizarChat(@PathVariable int id, @RequestBody Chat chat) {
        chat.setIdChat(id);
        return ResponseEntity.ok(chatServicio.save(chat));
    }

    @DeleteMapping("/eliminarChat/{id}")
    public ResponseEntity<Void> eliminarChat(@PathVariable int id) {
        chatServicio.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarChatsPorEstado/{estado}")
    public ResponseEntity<List<ChatGeneralDTO>> listarChatsPorEstado(@PathVariable String estado) {
        ModelMapper m = new ModelMapper();
        List<ChatGeneralDTO> lista = chatServicio.listarPorEstado(estado).stream()
                .map(y -> m.map(y, ChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listarChatsPorTipo/{tipo}")
    public ResponseEntity<List<ChatGeneralDTO>> listarChatsPorTipo(@PathVariable String tipo) {
        ModelMapper m = new ModelMapper();
        List<ChatGeneralDTO> lista = chatServicio.listarPorTipo(tipo).stream()
                .map(y -> m.map(y, ChatGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
