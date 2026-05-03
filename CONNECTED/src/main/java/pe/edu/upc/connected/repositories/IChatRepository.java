package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Chat;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Integer> {
}
