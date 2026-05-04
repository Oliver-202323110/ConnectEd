package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.ConexionListDTO;
import pe.edu.upc.connected.entities.Conexion;
import pe.edu.upc.connected.servicesinterfaces.IConexionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/conexiones")
public class ConexionController {

    @Autowired
    private IConexionService conexionServicio;

    @GetMapping("/listarConexiones")
    public ResponseEntity<List<ConexionListDTO>> listarConexiones() {
        ModelMapper m = new ModelMapper();
        List<ConexionListDTO> lista = conexionServicio.list().stream()
                .map(c -> m.map(c, ConexionListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/guardarConexion")
    public ResponseEntity<Conexion> guardarConexion(@RequestBody Conexion conexion) {
        return ResponseEntity.ok(conexionServicio.save(conexion));
    }

    @PutMapping("/actualizarConexion/{id}")
    public ResponseEntity<Conexion> actualizarConexion(@PathVariable int id, @RequestBody Conexion conexion) {
        conexion.setIdConexion(id);
        return ResponseEntity.ok(conexionServicio.save(conexion));
    }

    @DeleteMapping("/eliminarConexion/{id}")
    public ResponseEntity<Void> eliminarConexion(@PathVariable int id) {
        conexionServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}