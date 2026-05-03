package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.CalificacionMentoriaGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.ICalificacionMentoriaService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/CalificacionMentoria")
public class CalificacionMentoriaController {
    @Autowired
    private ICalificacionMentoriaService cS;
    @Autowired
    private IUsuarioService uS;
    @GetMapping("/lista")
    public ResponseEntity<List<CalificacionMentoriaGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<CalificacionMentoriaGeneralDTO> lista = cS.list()
                .stream()
                .map(y -> m.map(y, CalificacionMentoriaGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
