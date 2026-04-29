package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.connected.entities.RecomendacionSistema;

public interface IRecomendacionSistemaRepository extends JpaRepository<RecomendacionSistema, Integer> {
}
