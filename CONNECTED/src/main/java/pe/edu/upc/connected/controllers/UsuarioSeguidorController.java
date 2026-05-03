package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.UsuarioSeguidorListDTO;
import pe.edu.upc.connected.entities.UsuarioSeguidor;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioSeguidorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/seguidores")
public class UsuarioSeguidorController {

    @Autowired
    private IUsuarioSeguidorService seguidorServicio;

    @GetMapping("/listarSeguidores")
    public ResponseEntity<List<UsuarioSeguidorListDTO>> listarSeguidores() {
        ModelMapper m = new ModelMapper();
        List<UsuarioSeguidorListDTO> lista = seguidorServicio.list().stream()
                .map(u -> m.map(u, UsuarioSeguidorListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/guardarSeguidor")
    public ResponseEntity<UsuarioSeguidor> guardarSeguidor(@RequestBody UsuarioSeguidor usuarioSeguidor) {
        return ResponseEntity.ok(seguidorServicio.save(usuarioSeguidor));
    }

    @PutMapping("/actualizarSeguidor/{id}")
    public ResponseEntity<UsuarioSeguidor> actualizarSeguidor(@PathVariable int id, @RequestBody UsuarioSeguidor usuarioSeguidor) {
        usuarioSeguidor.setIdUsuarioSeguidor(id);
        return ResponseEntity.ok(seguidorServicio.save(usuarioSeguidor));
    }

    @DeleteMapping("/eliminarSeguidor/{id}")
    public ResponseEntity<Void> eliminarSeguidor(@PathVariable int id) {
        seguidorServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}