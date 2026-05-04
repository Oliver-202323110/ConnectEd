package pe.edu.upc.connected.repositories;

import org.hibernate.query.criteria.JpaDerivedRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.RespuestaForo;

@Repository
public interface IRespuestaForoRepository extends JpaRepository<RespuestaForo, Integer> {
}
