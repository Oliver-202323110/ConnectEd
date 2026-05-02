package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Usuario;
import pe.edu.upc.connected.repositories.IUsuarioRepository;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

   @Autowired
   private IUsuarioRepository  uS;

   @Override
   public List<Usuario> list() { return uS.findAll(); }

   @Override
   public Optional<Usuario> listId(int id) {
      return uS.findById(id);
   }
}
