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
   /* @Autowired
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
    }*/
    /*@PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody MentoriaGeneralDTO dto) {
        ModelMapper m = new ModelMapper();

        // 1. Buscamos al ESTUDIANTE
        Optional<Usuario> estudiante = uS.listId(dto.getEstudianteIdUsuario());

        // 2. Buscamos al MENTOR
        Optional<Usuario> mentor = uS.listId(dto.getMentorIdUsuario());

        // 3. Validamos que AMBOS existan
        if (estudiante.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El estudiante no existe");
        }
        if (mentor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El mentor no existe");
        }

        // 4. Mapeamos los datos básicos del DTO a la Entidad
        Mentoria ment = m.map(dto, Mentoria.class);

        // 5. Asignamos manualmente los objetos Usuario encontrados
        ment.setEstudiante(estudiante.get());
        ment.setMentor(mentor.get());

        // 6. Guardamos y respondemos
        Mentoria guardada = meS.insert(ment);
        MentoriaGeneralDTO responseDTO = m.map(guardada, MentoriaGeneralDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }*/
}
