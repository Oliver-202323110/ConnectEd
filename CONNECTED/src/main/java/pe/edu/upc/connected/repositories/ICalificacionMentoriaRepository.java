package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.CalificacionMentoria;

@Repository
public interface ICalificacionMentoriaRepository extends JpaRepository<CalificacionMentoria,Integer> {
}
