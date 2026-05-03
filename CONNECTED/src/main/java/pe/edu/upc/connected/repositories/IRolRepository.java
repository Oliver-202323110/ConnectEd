package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Evento;
import pe.edu.upc.connected.entities.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
