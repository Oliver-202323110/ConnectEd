package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.EnlacePerfilGeneralDTO;
import pe.edu.upc.connected.dtos.PerfilGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IEnlacePerfilService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EnlacePerfilController {

    @Autowired
    private IEnlacePerfilService enlacePerfilServicio;

    @GetMapping("/listarEnlacesPerfiles")
    public ResponseEntity<List<EnlacePerfilGeneralDTO>> listarEnlacesPerfiles() {
        ModelMapper m = new ModelMapper();
        List<EnlacePerfilGeneralDTO> listaEnlacesPerfiles = enlacePerfilServicio.list().stream()
                .map(y -> m.map(y, EnlacePerfilGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaEnlacesPerfiles);
    }
}
