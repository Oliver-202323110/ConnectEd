package pe.edu.upc.connected.servicesinterfaces;

import pe.edu.upc.connected.entities.TemaForo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ITemaForoService {
    public List<TemaForo> list();
    public Optional<TemaForo> listId(int id);
    public TemaForo insert(TemaForo tmf);
    public void update(TemaForo tmfU);
    public void delete(int id);
}
