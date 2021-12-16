package cl.desafiolatam.PruebaSistemaIMDb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.PruebaSistemaIMDb.mapper.UsersMapper;
import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsersMapper userMapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario users = userMapper.findByEmail(email);
		System.out.println(users);
		if (users == null)
			throw new UsernameNotFoundException(email);
		List<GrantedAuthority> authorities = new ArrayList<>();
		//authorities.add(new SimpleGrantedAuthority(users.getRole().toString()));
		System.out.println(users.getRol().getName());
		authorities.add(new SimpleGrantedAuthority(users.getRol().getName()));
		return new User(users.getEmail(), users.getPass(), authorities);
	}

	

	
}
