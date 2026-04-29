package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.GrupoNetworkingGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IGrupoNetworkingService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GrupoNetworkingController {

    @Autowired
    private IGrupoNetworkingService grupoNetworkingServicio;

    @GetMapping("/listarGruposNetworking")
    public ResponseEntity<List<GrupoNetworkingGeneralDTO>> listarGruposNetworking() {
        ModelMapper m = new ModelMapper();
        List<GrupoNetworkingGeneralDTO> listaGruposNetworking = grupoNetworkingServicio.list().stream()
                .map(y -> m.map(y, GrupoNetworkingGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaGruposNetworking);
    }
}
