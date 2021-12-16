package cl.desafiolatam.PruebaSistemaIMDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Long>{
	

	Usuario findByUsername(String username);
	boolean existsByUsername(String username);
	

	Usuario findByEmail(String  email);
	
	

}
