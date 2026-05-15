package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.PerfilGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioListDTO;
import pe.edu.upc.connected.entities.Perfil;
import pe.edu.upc.connected.entities.Rol;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IPerfilService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private IPerfilService pS;

    @Autowired
    private IUsuarioService uS;

    @GetMapping("/listarPerfiles")
    public ResponseEntity<List<PerfilGeneralDTO>> listarPerfiles() {
        ModelMapper m = new ModelMapper();
        List<PerfilGeneralDTO> listaPerfiles = pS.list().stream()
                .map(y -> m.map(y, PerfilGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaPerfiles);
    }

    @PostMapping("/registrar-perfil")
    public ResponseEntity<?> registrar(@RequestBody PerfilGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Optional<Usuario> usuario = uS.listId(dto.getIdUsuario());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }
        Perfil p = m.map(dto, Perfil.class);

        Perfil perf = pS.insert(p);
        PerfilGeneralDTO responseDTO = m.map(perf, PerfilGeneralDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }
}
