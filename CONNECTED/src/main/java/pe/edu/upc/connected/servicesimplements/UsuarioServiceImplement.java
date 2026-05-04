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
   private IUsuarioRepository  usuarioRepositorio;

   @Override
   public List<Usuario> list() { return UsuarioRepositorio.findAll(); }

   @Override
   public Usuario insert(Usuario u) {
      return UsuarioRepositorio.save(u);
   }

   @Override
   public void update(Usuario u) {
      UsuarioRepositorio.save(u);
   }


   public List<Usuario> list() { return usuarioRepositorio.findAll(); }

   @Override
   public Optional<Usuario> listId(int id) {
      return usuarioRepositorio.findById(id);
   }
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
    public Optional<Usuario> listId(int id) {
        return uR.findById(id);
    }
}
