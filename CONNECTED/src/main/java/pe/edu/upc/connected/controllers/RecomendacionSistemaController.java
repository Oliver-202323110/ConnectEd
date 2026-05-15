package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.EnlacePerfilGeneralDTO;
import pe.edu.upc.connected.dtos.RecomendacionSistemaGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IRecomendacionSistemaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendacion")
public class RecomendacionSistemaController {

    @Autowired
    private IRecomendacionSistemaService recomendacionSistemaServicio;

    @GetMapping("/listarRecomendacionesSistema")
    public ResponseEntity<List<RecomendacionSistemaGeneralDTO>> listarRecomendacionesSistema() {
        ModelMapper m = new ModelMapper();
        List<RecomendacionSistemaGeneralDTO> listaRecomendacionesSistema = recomendacionSistemaServicio.list().stream()
                .map(y -> m.map(y, RecomendacionSistemaGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaRecomendacionesSistema);
    }
}
