package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Publicacion;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion,Integer> {
}
