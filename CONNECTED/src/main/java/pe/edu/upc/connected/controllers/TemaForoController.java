package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.TemaForoGeneralDTO;
import pe.edu.upc.connected.entities.Foro;
import pe.edu.upc.connected.entities.TemaForo;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IForoService;
import pe.edu.upc.connected.servicesinterfaces.ITemaForoService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TemaForoController {

    @Autowired
    private ITemaForoService tfS;

    @Autowired
    private IForoService fS;

    @Autowired
    private IUsuarioService uS;

    @GetMapping("/listar-temasforos")
    public ResponseEntity<List<TemaForoGeneralDTO>> listarTemasForos() {
        ModelMapper m = new ModelMapper();
        List<TemaForoGeneralDTO> listaTemasForos = tfS.list().stream()
                .map(y -> m.map(y, TemaForoGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaTemasForos);
    }

    @PostMapping("/registrar-temaforo")
    public ResponseEntity<?> registrar(@RequestBody TemaForoGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Optional<Foro> fo = fS.listId(dto.getIdForo());
        if (fo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El foro no existe");
        }
        Optional<Usuario> usu = uS.listId(dto.getIdUsuario());
        if (usu.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        TemaForo tf = m.map(dto, TemaForo.class);
        tf.setUsuario(usu.get());
        tf.setForo(fo.get());
        TemaForo temaforo = tfS.insert(tf);
        TemaForoGeneralDTO responseDTO = m.map(temaforo, TemaForoGeneralDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @PutMapping("/actualizar-temaforo")
    public ResponseEntity<String> actualizar(@RequestBody TemaForoGeneralDTO dto) {
        Optional<Usuario> usu = uS.listId(dto.getIdUsuario());
        if (usu.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        Optional<Foro> fo = fS.listId(dto.getIdForo());
        if (fo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El foro no existe");
        }
        Optional<TemaForo> existente = tfS.listId(dto.getIdForo());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tema de Foro no encontrado");
        }

        TemaForo temForo = existente.get();

        temForo.setTitulo(dto.getTitulo());
        temForo.setContenido(dto.getContenido());
        temForo.setFechaCreacion(dto.getFechaCreacion());
        tfS.update(temForo);
        return ResponseEntity.ok("Tema de Foro actualizado correctamente");
    }

    @DeleteMapping("/eliminar-temaforo/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<TemaForo> temaForoEliminar = tfS.listId(id);
        if (temaForoEliminar.isPresent()) {
            tfS.delete(id);
            return ResponseEntity.ok("Tema de Foro eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tema de Foro no encontrado");
        }
    }
}
