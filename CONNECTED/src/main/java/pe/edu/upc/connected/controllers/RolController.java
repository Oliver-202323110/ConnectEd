package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.RolDTO;
import pe.edu.upc.connected.entities.Rol;
import pe.edu.upc.connected.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rolServicio;

    @GetMapping("/listarRoles")
    public ResponseEntity<List<RolDTO>> listarRoles() {
        ModelMapper m = new ModelMapper();
        List<RolDTO> listaRoles = rolServicio.list().stream()
                .map(y -> m.map(y, RolDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaRoles);
    }

    @PostMapping("/registrar-rol")
    public ResponseEntity<?> registrar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r=m.map(dto, Rol.class);
        r.setIdRol(0);
        Rol rol= rolServicio.insert(r);
        RolDTO responseDTO=m.map(rol,RolDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
