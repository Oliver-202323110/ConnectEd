package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioListDTO;
import pe.edu.upc.connected.servicesinterfaces.IForoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ForoController {

    @Autowired
    private IForoService foroServicio;

    @GetMapping("/listarForos")
    public ResponseEntity<List<ForoGeneralDTO>> listarForos() {
        ModelMapper m = new ModelMapper();
        List<ForoGeneralDTO> listaForos = foroServicio.list().stream()
                .map(y -> m.map(y, ForoGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaForos);
    }
}
