package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.repositories.IUsuarioRepository;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

   @Autowired
   private IUsuarioRepository  UsuarioRepositorio;

   @Override
   public List<Usuario> list() { return UsuarioRepositorio.findAll(); }

   @Override
   public Usuario insert(Usuario u) {
      return UsuarioRepositorio.save(u);
   }


}
