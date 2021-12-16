package cl.desafiolatam.PruebaSistemaIMDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.desafiolatam.PruebaSistemaIMDb.model.Rating;

public interface RatingRepository extends JpaRepository<Rating,Long>{

}
