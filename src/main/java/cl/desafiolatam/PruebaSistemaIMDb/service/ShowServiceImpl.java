package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.PruebaSistemaIMDb.model.Show;
import cl.desafiolatam.PruebaSistemaIMDb.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private ShowRepository showRepository;
	
	@Override
	public void create(Show show) {
		showRepository.save(show);
	}

	@Override
	public List<Show> findAll() {
		return showRepository.findAll();
	}

	@Override
	public Show findById(Long id) {
		return showRepository.findByid(id);
	}
	@Override
	public void update(Show show) {
		showRepository.save(show);
	}

	@Override
	public void delete(Long id) {
		showRepository.deleteById(id);;
	}
}
