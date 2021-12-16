package cl.desafiolatam.PruebaSistemaIMDb.mapper;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;

public interface UsersMapper extends CrudRepository<Usuario,Long>{
	/*@Select("select * from usuarios where email = #{email}")
	User findByEmail(@Param("email") String email);
	*/
	@Query("FROM Usuario WHERE email =  ?1")
	public Usuario findByEmail(String email);
}