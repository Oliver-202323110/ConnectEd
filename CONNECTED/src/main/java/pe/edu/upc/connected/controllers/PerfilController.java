package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.PerfilGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioListDTO;
import pe.edu.upc.connected.servicesinterfaces.IPerfilService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PerfilController {

    @Autowired
    private IPerfilService perfilServicio;

    @GetMapping("/listarPerfiles")
    public ResponseEntity<List<PerfilGeneralDTO>> listarPerfiles() {
        ModelMapper m = new ModelMapper();
        List<PerfilGeneralDTO> listaPerfiles = perfilServicio.list().stream()
                .map(y -> m.map(y, PerfilGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaPerfiles);
    }
}
