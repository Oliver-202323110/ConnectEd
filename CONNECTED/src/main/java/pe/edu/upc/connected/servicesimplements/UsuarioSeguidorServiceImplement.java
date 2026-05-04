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
    private IUsuarioSeguidorRepository UsuarioSeguidorRepositorio;

    @Override
    public List<UsuarioSeguidor> list() { return UsuarioSeguidorRepositorio.findAll(); }

    @Override
    public UsuarioSeguidor save(UsuarioSeguidor usuarioSeguidor) { return UsuarioSeguidorRepositorio.save(usuarioSeguidor); }

    @Override
    public UsuarioSeguidor findById(int id) { return UsuarioSeguidorRepositorio.findById(id).orElse(null); }

    @Override
    public void delete(int id) { UsuarioSeguidorRepositorio.deleteById(id); }
}