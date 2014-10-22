package br.com.ceafssystem.domain.atividade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ceafssystem.domain.exercicio.ExercicioPO;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "atividade_exercicio" )
public class AtividadeExercicioPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	/*	private Boolean avaliacao;*/

	@ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_exercicio", nullable = false )
	private ExercicioPO exercicio;

	public AtividadeExercicioPO(){}

	/**
	 * Método responsável por retornar o valor do atributo id.
	 * 
	 * @return Long id - id a ser retornado(a).
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo id.
	 * 
	 * @param Long id - id a ser atribuido(a).
	 */
	public void setId( Long id ) {
		this.id = id;
	}

	/**
	 * Método responsável por retornar o valor do atributo exercicio.
	 * 
	 * @return ExercicioPO exercicio - exercicio a ser retornado(a).
	 */
	public ExercicioPO getExercicio() {
		return exercicio;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo exercicio.
	 * 
	 * @param ExercicioPO exercicio - exercicio a ser atribuido(a).
	 */
	public void setExercicio( ExercicioPO exercicio ) {
		this.exercicio = exercicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( exercicio == null ) ? 0 : exercicio.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( getClass() != obj.getClass() ) {
			return false;
		}
		AtividadeExercicioPO other = (AtividadeExercicioPO) obj;
		if ( exercicio == null ) {
			if ( other.exercicio != null ) {
				return false;
			}
		} else if ( !exercicio.equals( other.exercicio ) ) {
			return false;
		}
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AtividadeExercicioPO [getId()=" + getId() + ", getExercicio()=" + getExercicio() + "]";
	}

}
