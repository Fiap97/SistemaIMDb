package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.List;

import cl.desafiolatam.PruebaSistemaIMDb.model.Rating;

public interface RatingService {

	void save(Rating rating);
	List<Rating> findAll();
	
}
