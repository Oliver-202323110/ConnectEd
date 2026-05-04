package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Foro;

@Repository
public interface IForoRepository extends JpaRepository<Foro, Integer> {
}
