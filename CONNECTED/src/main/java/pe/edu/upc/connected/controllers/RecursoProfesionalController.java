package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.PublicacionGeneralDTO;
import pe.edu.upc.connected.dtos.RecursoProfesionalGeneralDTO;
import pe.edu.upc.connected.entities.Publicacion;
import pe.edu.upc.connected.entities.RecursoProfesional;
import pe.edu.upc.connected.servicesinterfaces.IPublicacionService;
import pe.edu.upc.connected.servicesinterfaces.IRecursoProfesionalService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Recursoprofesional")
public class RecursoProfesionalController {
    @Autowired
    private IRecursoProfesionalService rS;
    @Autowired
    private IPublicacionService pS;

    @GetMapping("/lista")
    public ResponseEntity<List<RecursoProfesionalGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<RecursoProfesionalGeneralDTO> lista = rS.list()
                .stream()
                .map(y -> m.map(y, RecursoProfesionalGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody RecursoProfesionalGeneralDTO dto) {

        ModelMapper m = new ModelMapper();
        Optional<Publicacion> publicacion = pS.listId(dto.getIdPublicacion());
        if (publicacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La publicacion no existe");
        }
        RecursoProfesional rec = m.map(dto, RecursoProfesional.class);
        rec.setPublicacion(publicacion.get());

        RecursoProfesional compt = rS.insert(rec);
        RecursoProfesionalGeneralDTO responseDTO = m.map(compt, RecursoProfesionalGeneralDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<RecursoProfesional> tar = rS.listId(id);

        if (tar.isPresent()) {
            RecursoProfesionalGeneralDTO dto = m.map(tar.get(), RecursoProfesionalGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso profesional no encontrado");
        }
    }
    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody RecursoProfesionalGeneralDTO dto) {

        Optional<RecursoProfesional> existente = rS.listId(dto.getIdRecursoProfesional());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso profesional no encontrado");
        }

            Optional<Publicacion> publicacion = pS.listId(dto.getIdPublicacion());

        if (publicacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }

        RecursoProfesional rec = existente.get();

        rec.setTituloRecursoProfesional(dto.getTituloRecursoProfesional());
        rec.setCategoriaRecursoProfesional(dto.getCategoriaRecursoProfesional());
        rec.setCategoriaRecursoProfesional(dto.getCategoriaRecursoProfesional());
        rec.setUrlRecursoProfesional(dto.getUrlRecursoProfesional());
        rec.setFormatoRecursoProfesional(dto.getFormatoRecursoProfesional());
        rec.setDescripcionformatoRecursoProfesional(dto.getDescripcionformatoRecursoProfesional());
        rec.setPublicacion(publicacion.get());

        rS.update(rec);

        return ResponseEntity.ok("Recurso profesional actualizado correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<RecursoProfesional> recursoProfesional = rS.listId(id);

        if (recursoProfesional.isPresent()) {
            rS.delete(id);
            return ResponseEntity.ok("Recurso profesional eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso profesional no encontrada");
        }
    }
}
