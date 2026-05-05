package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.TemaForo;
import pe.edu.upc.connected.repositories.ITemaForoRepository;
import pe.edu.upc.connected.servicesinterfaces.ITemaForoService;

import java.util.List;
import java.util.Optional;

@Service
public class TemaForoServiceImplement implements ITemaForoService {

    @Autowired
    private ITemaForoRepository tfR;

    @Override
    public List<TemaForo> list() {
        return tfR.findAll();
    }

    @Override
    public Optional<TemaForo> listId(int id) {
        return tfR.findById(id);
    }

    @Override
    public TemaForo insert(TemaForo tmf) {
        return tfR.save(tmf);
    }

    @Override
    public void update(TemaForo tmfU) {
        tfR.save(tmfU);
    }

    @Override
    public void delete(int id) {
        tfR.deleteById(id);
    }


}
