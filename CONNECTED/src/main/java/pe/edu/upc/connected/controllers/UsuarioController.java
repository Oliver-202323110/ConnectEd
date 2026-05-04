package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.connected.dtos.UsuarioGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioListDTO;
import pe.edu.upc.connected.entities.Rol;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IRolService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @Autowired
    private IRolService rolServicio;

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioListDTO>> listarUsuarios() {
        ModelMapper m = new ModelMapper();
        List<UsuarioListDTO> listaUsuarios = uS.list().stream()
                .map(y -> m.map(y, UsuarioListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaUsuarios);
    }

    @PostMapping("/registrar-usuario")
    public ResponseEntity<?> registrar(@RequestBody UsuarioGeneralDTO dto){
        if (dto.getRol() == null || dto.getRol().getIdRol() <= 0) {
            return ResponseEntity.badRequest().body("Debe enviar un rol existente con idRol.");
        }

        Rol rol = rolServicio.listId(dto.getRol().getIdRol())
                .orElse(null);

        if (rol == null) {
            return ResponseEntity.badRequest().body("No existe un rol con idRol " + dto.getRol().getIdRol() + ".");
        }

        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        u.setRol(rol);
        Usuario usu= uS.insert(u);
        UsuarioGeneralDTO responseDTO=m.map(usu,UsuarioGeneralDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
