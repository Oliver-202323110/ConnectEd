package pe.edu.upc.connected.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.connected.entities.Publicacion;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion,Integer> {
    @Query("SELECT p.usuario.nombres, COUNT(p) FROM Publicacion p GROUP BY p.usuario.nombres")
    List<Object[]> countPublicacionesByUser();

    @Query("SELECT p FROM Publicacion p WHERE p.fechaPublicacion BETWEEN :f1 AND :f2")
    List<Publicacion> buscarPorRangoDeFechas(@Param("f1") LocalDate f1, @Param("f2") LocalDate f2);
}
