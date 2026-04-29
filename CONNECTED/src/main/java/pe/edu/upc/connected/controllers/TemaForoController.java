package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.TemaForoGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.ITemaForoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TemaForoController {

    @Autowired
    private ITemaForoService temaForoServicio;

    @GetMapping("/listarTemasForos")
    public ResponseEntity<List<TemaForoGeneralDTO>> listarTemasForos() {
        ModelMapper m = new ModelMapper();
        List<TemaForoGeneralDTO> listaTemasForos = temaForoServicio.list().stream()
                .map(y -> m.map(y, TemaForoGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaTemasForos);
    }
}
