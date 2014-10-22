package br.com.ceafssystem.domain.aula;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ceafssystem.domain.atividade.AtividadeExercicioPO;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "aula_exercicio" )
public class AulaExercicioPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn( name = "id_atividade_exercicio", nullable = false )
	private AtividadeExercicioPO atividadeExercicio;

	public AulaExercicioPO(){}

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
	 * Método responsável por retornar o valor do atributo atividadeExercicio.
	 * 
	 * @return AtividadeExercicioPO atividadeExercicio - atividadeExercicio a ser retornado(a).
	 */
	public AtividadeExercicioPO getAtividadeExercicio() {
		return atividadeExercicio;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo atividadeExercicio.
	 * 
	 * @param AtividadeExercicioPO atividadeExercicio - atividadeExercicio a ser atribuido(a).
	 */
	public void setAtividadeExercicio( AtividadeExercicioPO atividadeExercicio ) {
		this.atividadeExercicio = atividadeExercicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( atividadeExercicio == null ) ? 0 : atividadeExercicio.hashCode() );
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
		AulaExercicioPO other = (AulaExercicioPO) obj;
		if ( atividadeExercicio == null ) {
			if ( other.atividadeExercicio != null ) {
				return false;
			}
		} else if ( !atividadeExercicio.equals( other.atividadeExercicio ) ) {
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
		return "AulaExercicioPO [getId()=" + getId() + ", getAtividadeExercicio()=" + getAtividadeExercicio() + ", hashCode()=" + hashCode() + "]";
	}

}
