package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.ForoParticipanteGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IForoParticipanteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ForoParticipanteController {

    @Autowired
    private IForoParticipanteService foroParticipanteServicio;

    @GetMapping("/listarForosParticipantes")
    public ResponseEntity<List<ForoParticipanteGeneralDTO>> listarForosParticipantes() {
        ModelMapper m = new ModelMapper();
        List<ForoParticipanteGeneralDTO> listaForosParticipantes = foroParticipanteServicio.list().stream()
                .map(y -> m.map(y, ForoParticipanteGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaForosParticipantes);
    }
}
