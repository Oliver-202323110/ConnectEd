package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.CalificacionMentoriaGeneralDTO;
import pe.edu.upc.connected.entities.CalificacionMentoria;
import pe.edu.upc.connected.entities.Mentoria;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.ICalificacionMentoriaService;
import pe.edu.upc.connected.servicesinterfaces.IMentoriaService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/CalificacionMentoria")
public class CalificacionMentoriaController {
    @Autowired
    private ICalificacionMentoriaService cS;
    @Autowired
    private IMentoriaService meS;
    @Autowired
    private IUsuarioService uS;
    @GetMapping("/lista")
    public ResponseEntity<List<CalificacionMentoriaGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<CalificacionMentoriaGeneralDTO> lista = cS.list()
                .stream()
                .map(y -> m.map(y, CalificacionMentoriaGeneralDTO.class))
                .collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody CalificacionMentoriaGeneralDTO dto) {
        ModelMapper m = new ModelMapper();

        Optional<Mentoria> mentoria = meS.listId(dto.getIdMentoria());
        if (mentoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La mentoría no existe");
        }
        Optional<Usuario> usuario = uS.listId(dto.getIdUsuario());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        CalificacionMentoria cali = m.map(dto, CalificacionMentoria.class);

        cali.setMentoria(mentoria.get());
        cali.setUsuario(usuario.get());

        CalificacionMentoria guardada = cS.insert(cali);

        CalificacionMentoriaGeneralDTO responseDTO = m.map(guardada, CalificacionMentoriaGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();

        Optional<CalificacionMentoria> cali = cS.listId(id);

        if (cali.isPresent()) {
            CalificacionMentoriaGeneralDTO dto = m.map(cali.get(), CalificacionMentoriaGeneralDTO.class);

            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Calificación de mentoría no encontrada");
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody CalificacionMentoriaGeneralDTO dto) {
        Optional<CalificacionMentoria> existente = cS.listId(dto.getIdCalificacionMentoria());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Calificación no encontrada");
        }

        Optional<Mentoria> mentoria = meS.listId(dto.getIdMentoria());
        if (mentoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La mentoría no existe");
        }

        Optional<Usuario> usuario = uS.listId(dto.getIdUsuario());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }

        CalificacionMentoria cali = existente.get();

        cali.setPuntuacionCalificacionMentoria(dto.getPuntuacionCalificacionMentoria());
        cali.setComentarioCalificacionMentoria(dto.getComentarioCalificacionMentoria());
        cali.setDateCalificacionMentoria(dto.getDateCalificacionMentoria());

        cali.setMentoria(mentoria.get());
        cali.setUsuario(usuario.get());

        cS.update(cali);

        return ResponseEntity.ok("Calificación actualizada correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<CalificacionMentoria> cali = cS.listId(id);

        if (cali.isPresent()) {
            cS.delete(id);
            return ResponseEntity.ok("Calificación eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Calificación no encontrada");
        }
    }
}
