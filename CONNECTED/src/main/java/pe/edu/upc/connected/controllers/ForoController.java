package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioGeneralDTO;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.entities.Rol;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IForoService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foro")
public class ForoController {

    @Autowired
    private IForoService fS;

    @Autowired
    private IUsuarioService uS;

    @GetMapping("/listar-foros")
    public ResponseEntity<List<ForoGeneralDTO>> listarForos() {
        ModelMapper m = new ModelMapper();
        List<ForoGeneralDTO> listaForos = fS.list().stream()
                .map(y -> m.map(y, ForoGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaForos);
    }

    @PostMapping("/registrar-foro")
    public ResponseEntity<?> registrar(@RequestBody ForoGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Optional<Usuario> usu = uS.listId(dto.getIdUsuario());
        if (usu.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        Foro f = m.map(dto, Foro.class);
        f.setUsuario(usu.get());
        Foro foro = fS.insert(f);
        ForoGeneralDTO responseDTO = m.map(foro, ForoGeneralDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @PutMapping("/actualizar-foro")
    public ResponseEntity<String> actualizar(@RequestBody ForoGeneralDTO dto) {
        Optional<Usuario> usu = uS.listId(dto.getIdUsuario());
        if (usu.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        Optional<Foro> existente = fS.listId(dto.getIdUsuario());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Foro no encontrado");
        }

        Foro foro = existente.get();

        foro.setTitulo(dto.getTitulo());
        foro.setDescripcion(dto.getDescripcion());
        foro.setEstado(dto.getEstado());
        foro.setFechaCreacion(dto.getFechaCreacion());
        fS.update(foro);
        return ResponseEntity.ok("Foro actualizado correctamente");
    }

    @DeleteMapping("/eliminar-foro/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Foro> foroEliminar = fS.listId(id);
        if (foroEliminar.isPresent()) {
            fS.delete(id);
            return ResponseEntity.ok("Foro eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Foro no encontrado");
        }
    }
}
