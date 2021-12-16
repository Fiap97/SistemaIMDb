package cl.desafiolatam.PruebaSistemaIMDb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name="SQ_USUARIOSHOW", initialValue=1, allocationSize=1)
public class UsuarioShow {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_USUARIOSHOW")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "show_id", referencedColumnName = "id")
	private Show show;
	@ManyToOne
	@JoinColumn(name = "rating_id", referencedColumnName = "id")
	private Rating rating;
	@Override
	public String toString() {
		return "UsuarioShow [id=" + id + ", usuario=" + usuario + ", show=" + show + ", rating=" + rating + "]";
	}
	
	
}
