package cl.desafiolatam.PruebaSistemaIMDb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;
import cl.desafiolatam.PruebaSistemaIMDb.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(Usuario user) {
		if (!userRepository.existsByUsername(user.getUsername())) {
			user.setPass(passwordEncoder.encode(user.getPass()));
			user.setPasswordConfirmation(passwordEncoder.encode(user.getPasswordConfirmation()));
			userRepository.save(user);
			return true;
		}	
		return false;
	}

	@Override
	public Usuario getUsuarioByCorreo(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
