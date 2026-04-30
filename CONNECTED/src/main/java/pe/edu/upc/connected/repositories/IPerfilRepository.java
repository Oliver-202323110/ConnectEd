package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.connected.entities.Perfil;

public interface IPerfilRepository extends JpaRepository<Perfil, Integer> {
}
