package pe.edu.upc.connected.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.connected.dtos.CantidadEstadoDTO;
import pe.edu.upc.connected.dtos.UsuarioGeneralDTO;
import pe.edu.upc.connected.dtos.UsuarioListDTO;
import pe.edu.upc.connected.entities.Rol;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.servicesinterfaces.IRolService;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @PostMapping("/nuevo")
    public ResponseEntity<?> registrar(@RequestBody UsuarioGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Optional<Rol> rol = rolServicio.listId(dto.getIdRol());
        if (rol.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El rol no existe");
        }
        Usuario u = m.map(dto, Usuario.class);
        u.setRol(rol.get());

        Usuario usu = uS.insert(u);
        UsuarioGeneralDTO responseDTO = m.map(usu, UsuarioGeneralDTO.class);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @PutMapping("/actualizar-usuario")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioGeneralDTO dto) {
        Optional<Rol> rol = rolServicio.listId(dto.getIdRol());
        if (rol.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El rol no existe");
        }
        Optional<Usuario> existente = uS.listId(dto.getIdUsuario());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Usuario usu = existente.get();

        usu.setNombres(dto.getNombres());
        usu.setApellidoPaterno(dto.getApellidoPaterno());
        usu.setApellidoMaterno(dto.getApellidoMaterno());
        usu.setContraseña(dto.getContraseña());
        usu.setCorreo(dto.getCorreo());
        usu.setEstadoCuenta(dto.getEstadoCuenta());
        usu.setUltimaSesion(dto.getUltimaSesion());
        uS.update(usu);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Usuario> usuarioEliminar = uS.listId(id);

        if (usuarioEliminar.isPresent()) {
            uS.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @GetMapping("/cantidad-estados")
    public ResponseEntity<?> obtenerCantidad(){
        List<Object[]> lista = uS.buscarNativeQuery();
        if (lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay registros");
        }
        List<CantidadEstadoDTO> respuesta = new ArrayList<>();
        for (Object[] fila : lista){
            CantidadEstadoDTO dto = new CantidadEstadoDTO();
            dto.setEstadoCuenta(((String)fila[0]));
            dto.setCantidad(((Number)fila[1]).intValue());
            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }
}
