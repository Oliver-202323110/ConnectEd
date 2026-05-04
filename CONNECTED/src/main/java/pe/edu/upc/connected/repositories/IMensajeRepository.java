package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Mensaje;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {
}
