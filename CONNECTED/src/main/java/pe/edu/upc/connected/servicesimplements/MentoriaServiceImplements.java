package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.Mentoria;
import pe.edu.upc.connected.repositories.IMentoriaRepository;
import pe.edu.upc.connected.servicesinterfaces.IMentoriaService;

import java.util.List;
import java.util.Optional;

@Service
public class MentoriaServiceImplements implements IMentoriaService {
    @Autowired
    private IMentoriaRepository mR;
    @Override
    public List<Mentoria> list() {
        return mR.findAll();
    }

    @Override
    public Mentoria insert(Mentoria m) {
        return mR.save(m);
    }

    @Override
    public Optional<Mentoria> listId(int id) {
        return mR.findById(id);
    }

    @Override
    public void update(Mentoria m) {
        mR.save(m);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }
}
