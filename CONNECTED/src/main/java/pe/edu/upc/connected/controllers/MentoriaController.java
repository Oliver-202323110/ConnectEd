package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.MentoriaGeneralDTO;
import pe.edu.upc.connected.entities.Mentoria;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IMentoriaService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Mentoria")
public class MentoriaController {
    @Autowired
    private IMentoriaService meS;
    @Autowired
    private IUsuarioService uS;
    @GetMapping("/lista")
    public ResponseEntity<List<MentoriaGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<MentoriaGeneralDTO> lista = meS.list()
                .stream()
                .map(y -> m.map(y, MentoriaGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody MentoriaGeneralDTO dto) {
        ModelMapper m = new ModelMapper();

        Optional<Usuario> estudiante = uS.listId(dto.getEstudianteIdUsuario());
        Optional<Usuario> mentor = uS.listId(dto.getMentorIdUsuario());

        if (estudiante.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El estudiante no existe");
        }
        if (mentor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El mentor no existe");
        }

        Mentoria ment = m.map(dto, Mentoria.class);
        ment.setEstudiante(estudiante.get());
        ment.setMentor(mentor.get());
        Mentoria guardada = meS.insert(ment);
        MentoriaGeneralDTO responseDTO = m.map(guardada, MentoriaGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();

        Optional<Mentoria> mentoria = meS.listId(id);
        if (mentoria.isPresent()) {
            MentoriaGeneralDTO dto = m.map(mentoria.get(), MentoriaGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mentoría no encontrada");
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody MentoriaGeneralDTO dto) {
        Optional<Mentoria> existente = meS.listId(dto.getIdMentoria());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mentoría no encontrada");
        }
        Optional<Usuario> estudiante = uS.listId(dto.getEstudianteIdUsuario());
        if (estudiante.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El estudiante no existe");
        }
        Optional<Usuario> mentor = uS.listId(dto.getMentorIdUsuario());
        if (mentor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El mentor no existe");
        }
        Mentoria ment = existente.get();
        ment.setEstadoMentoria(dto.getEstadoMentoria());
        ment.setFechaInicioMentoria(dto.getFechaInicioMentoria());
        ment.setFechaFinMentoria(dto.getFechaFinMentoria());
        ment.setEstudiante(estudiante.get());
        ment.setMentor(mentor.get());
        meS.update(ment);

        return ResponseEntity.ok("Mentoría actualizada correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Mentoria> mentoria = meS.listId(id);
        if (mentoria.isPresent()) {
            meS.delete(id);
            return ResponseEntity.ok("Mentoría eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mentoría no encontrada");
        }
    }
}
