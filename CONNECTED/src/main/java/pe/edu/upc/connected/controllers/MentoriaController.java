package pe.edu.upc.connected.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.servicesinterfaces.IMentoriaService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

@RestController
@RequestMapping("/api/Mentoria")
public class MentoriaController {
    @Autowired
    private IMentoriaService meS;
    @Autowired
    private IUsuarioService uS;

}
