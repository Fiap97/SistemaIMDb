package cl.desafiolatam.PruebaSistemaIMDb.model;

import java.util.List;

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
@SequenceGenerator(name="SQ_RATING", initialValue=1, allocationSize=1)
public class Rating {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_RATING")
	private Long id;
	private int rating;
	
	@OneToMany(mappedBy="rating")
	private List<UsuarioShow> usuariosShows;

}
