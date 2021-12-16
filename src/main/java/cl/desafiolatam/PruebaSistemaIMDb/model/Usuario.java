package cl.desafiolatam.PruebaSistemaIMDb.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name="SQ_USUAR", initialValue=1, allocationSize=1)
@Table(name="usuar")
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_USUAR")
	private Long id;
	
	private String username;
	private String email;
	private String pass;
	private String passwordConfirmation;
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role rol;
	@OneToMany(mappedBy="usuario")
	private List<UsuarioShow> usuarioShow;
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", pass=" + pass
				+ ", passwordConfirmation=" + passwordConfirmation + ", rol=" + rol.getName() + "]";
	}
	
	
	
}
