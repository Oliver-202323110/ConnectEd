package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.PublicacionGeneralDTO;
import pe.edu.upc.connected.dtos.RecomendacionMentorGeneralDTO;
import pe.edu.upc.connected.servicesinterfaces.IRecomendacionMentorService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/RecomendacionMentor")
public class RecomendacionMentorController {
    @Autowired
    private IRecomendacionMentorService rS;
    @Autowired
    private IUsuarioService uS;
    @GetMapping("/lista")
    public ResponseEntity<List<RecomendacionMentorGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<RecomendacionMentorGeneralDTO> lista = rS.list()
                .stream()
                .map(y -> m.map(y, RecomendacionMentorGeneralDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
