package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.connected.entities.EnlacePerfil;

public interface IEnlacePerfilRepository extends JpaRepository<EnlacePerfil, Integer> {
}
