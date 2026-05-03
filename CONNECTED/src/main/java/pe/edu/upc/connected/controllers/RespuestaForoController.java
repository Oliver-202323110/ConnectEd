package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.RespuestaForoGeneralDTO;
import pe.edu.upc.connected.dtos.TemaForoGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IRespuestaForoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RespuestaForoController {

    @Autowired
    private IRespuestaForoService respuestaForoServicio;

    @GetMapping("/listarRespuestasForos")
    public ResponseEntity<List<RespuestaForoGeneralDTO>> listarRespuestasForos() {
        ModelMapper m = new ModelMapper();
        List<RespuestaForoGeneralDTO> listaRespuestasForos = respuestaForoServicio.list().stream()
                .map(y -> m.map(y, RespuestaForoGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaRespuestasForos);
    }
}
