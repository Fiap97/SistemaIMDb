package cl.desafiolatam.PruebaSistemaIMDb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name="SQ_SHOW", initialValue=1, allocationSize=1)
public class Show {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_SHOW")
	private Long id;
	
	private String showTitle;
	private String showNetwork;
	@OneToMany(mappedBy="show",cascade = CascadeType.ALL)
	private List<UsuarioShow> usuarioShow;
	
}
