package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.UsuarioGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioListDTO;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioServicio;

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioListDTO>> listarUsuarios() {
        ModelMapper m = new ModelMapper();
        List<UsuarioListDTO> listaUsuarios = usuarioServicio.list().stream()
                .map(y -> m.map(y, UsuarioListDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaUsuarios);
    }

    @PostMapping("/registrar-usuario")
    public ResponseEntity<?> registrar(@RequestBody UsuarioGeneralDTO dto){

        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        Usuario usu= usuarioServicio.insert(u);
        UsuarioGeneralDTO responseDTO=m.map(usu,UsuarioGeneralDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/actualizar-usuario")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioGeneralDTO dto) {
        Optional<Usuario> existente = usuarioServicio.listId(dto.getIdUsuario());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
        Usuario usu = existente.get();

        usu.setNombres(dto.getNombres());
        usu.setApellidoPaterno(dto.getApellidoPaterno());
        usu.setApellidoMaterno(dto.getApellidoMaterno());
        usu.setCorreo(dto.getCorreo());
        usu.setContraseña(dto.getContraseña());
        usu.setEstadoCuenta(dto.getEstadoCuenta());
        usu.setFechaRegistro(dto.getFechaRegistro());
        usu.setUltimaSesion(dto.getUltimaSesion());
        usuarioServicio.update(usu);

        return ResponseEntity.ok("Usuario actualizado correctamente");
    }
}
