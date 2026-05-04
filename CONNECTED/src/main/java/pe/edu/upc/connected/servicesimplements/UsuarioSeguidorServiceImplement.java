package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.UsuarioSeguidor;
import pe.edu.upc.connected.repositories.IUsuarioSeguidorRepository;
import pe.edu.upc.connected.servicesinterfaces.IUsuarioSeguidorService;

import java.util.List;

@Service
public class UsuarioSeguidorServiceImplement implements IUsuarioSeguidorService {

    @Autowired
    private IUsuarioSeguidorRepository uR;

    @Override
    public List<UsuarioSeguidor> list() { return uR.findAll(); }

    @Override
    public UsuarioSeguidor save(UsuarioSeguidor usuarioSeguidor) { return uR.save(usuarioSeguidor); }

    @Override
    public UsuarioSeguidor findById(int id) { return uR.findById(id).orElse(null); }

    @Override
    public void delete(int id) { uR.deleteById(id); }
}