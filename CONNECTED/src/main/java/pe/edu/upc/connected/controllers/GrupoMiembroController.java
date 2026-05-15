package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.ForoGeneralDTO;
import pe.edu.upc.connected.dtos.GrupoMiembroGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IGrupoMiembroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grupos")
public class GrupoMiembroController {

    @Autowired
    private IGrupoMiembroService grupoMiembroServicio;

    @GetMapping("/listarGruposMiembros")
    public ResponseEntity<List<GrupoMiembroGeneralDTO>> listarGruposMiembros() {
        ModelMapper m = new ModelMapper();
        List<GrupoMiembroGeneralDTO> listaGruposMiembros = grupoMiembroServicio.list().stream()
                .map(y -> m.map(y, GrupoMiembroGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaGruposMiembros);
    }
}
