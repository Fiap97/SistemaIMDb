package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.List;

import cl.desafiolatam.PruebaSistemaIMDb.model.UsuarioShow;

public interface UsuarioShowService {

	void save(UsuarioShow usuarioShow);
	List<UsuarioShow> findAll();
	
}
