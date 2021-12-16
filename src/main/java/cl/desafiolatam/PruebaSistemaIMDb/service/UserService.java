package cl.desafiolatam.PruebaSistemaIMDb.service;


import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;

public interface UserService {


	boolean signup(Usuario user);

	Usuario getUsuarioByCorreo(String username);
	
	Usuario getUsuarioByEmail(String email);

}
