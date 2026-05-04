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
   private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

   @Override
   public Usuario insert(Usuario u) {
      return uR.save(u);
   }

   @Override
   public void update(Usuario u) {
      uR.save(u);
   }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
   public Optional<Usuario> listId(int id) {
      return uR.findById(id);
   }


}
