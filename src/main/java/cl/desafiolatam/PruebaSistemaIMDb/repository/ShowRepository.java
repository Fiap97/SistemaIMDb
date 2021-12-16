package cl.desafiolatam.PruebaSistemaIMDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.desafiolatam.PruebaSistemaIMDb.model.Show;

public interface ShowRepository extends JpaRepository<Show,Long>{

	@Query("FROM Show WHERE id = ?1")
	Show findByid(Long id);
}
