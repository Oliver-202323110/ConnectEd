package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.PublicacionGeneralDTO;
import pe.edu.upc.connected.entities.Publicacion;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IPublicacionService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Publicacion")
public class PublicacionController {
    @Autowired
    private IPublicacionService pS;
    @Autowired
    private IUsuarioService uS;

    @GetMapping("/lista")
    public ResponseEntity<List<PublicacionGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<PublicacionGeneralDTO> lista = pS.list()
                .stream()
                .map(y -> m.map(y, PublicacionGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody PublicacionGeneralDTO dto) {

        ModelMapper m = new ModelMapper();
        Optional<Usuario> usuario = uS.listId(dto.getIdUsuario());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        Publicacion publ = m.map(dto, Publicacion.class);
        publ.setUsuario(usuario.get());

        Publicacion compt = pS.insert(publ);
        PublicacionGeneralDTO responseDTO = m.map(compt, PublicacionGeneralDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Publicacion> tar = pS.listId(id);

        if (tar.isPresent()) {
            PublicacionGeneralDTO dto = m.map(tar.get(), PublicacionGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publicacion no encontrada");
        }
    }
    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody PublicacionGeneralDTO dto) {

        Optional<Publicacion> existente = pS.listId(dto.getIdPublicacion());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publicacion no encontrada");
        }

        Optional<Usuario> usuario = uS.listId(dto.getIdUsuario());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }

        Publicacion publ = existente.get();

        publ.setContenidoPublicacion(dto.getContenidoPublicacion());
        publ.setTipoPublicacion(dto.getTipoPublicacion());
        publ.setVisibilidadPublicacion(dto.getVisibilidadPublicacion());
        publ.setFechaPublicacion(dto.getFechaPublicacion());
        publ.setUsuario(usuario.get());

        pS.update(publ);

        return ResponseEntity.ok("Publicacion actualizada correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Publicacion> publicacion = pS.listId(id);

        if (publicacion.isPresent()) {
            pS.delete(id);
            return ResponseEntity.ok("Publicacion eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publicacion no encontrada");
        }
    }
}
