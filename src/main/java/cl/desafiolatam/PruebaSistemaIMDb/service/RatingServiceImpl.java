package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.PruebaSistemaIMDb.model.Rating;
import cl.desafiolatam.PruebaSistemaIMDb.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public void save(Rating rating) {
		ratingRepository.save(rating);
	}

	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}

}
