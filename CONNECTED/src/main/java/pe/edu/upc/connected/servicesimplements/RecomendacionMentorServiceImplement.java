package pe.edu.upc.connected.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connected.entities.RecomendacionMentor;
import pe.edu.upc.connected.repositories.IRecomendacionMentorRepository;
import pe.edu.upc.connected.servicesinterfaces.IRecomendacionMentorService;

import java.util.List;

@Service
public class RecomendacionMentorServiceImplement implements IRecomendacionMentorService {
    @Autowired
    private IRecomendacionMentorRepository rR;
    @Override
    public List<RecomendacionMentor> list() {
        return rR.findAll();
    }
}
