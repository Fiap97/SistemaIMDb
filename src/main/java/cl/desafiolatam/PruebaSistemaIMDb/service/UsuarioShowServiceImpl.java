package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.PruebaSistemaIMDb.model.UsuarioShow;
import cl.desafiolatam.PruebaSistemaIMDb.repository.UsuarioShowRepository;

@Service
public class UsuarioShowServiceImpl implements UsuarioShowService{

	@Autowired
	UsuarioShowRepository usuarioShowRepository;
	
	@Override
	public void save(UsuarioShow usuarioShow) {
		usuarioShowRepository.save(usuarioShow);
	}

	@Override
	public List<UsuarioShow> findAll() {
		return usuarioShowRepository.findAll();
	}

}
