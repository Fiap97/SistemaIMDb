package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.List;

import cl.desafiolatam.PruebaSistemaIMDb.model.Show;


public interface ShowService {


	void create(Show show);
	List<Show> findAll();
	Show findById(Long id);
	void update(Show show);
	void delete(Long id);
}
