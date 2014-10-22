package br.com.ceafssystem.domain.exercicio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ceafssystem.domain.equipamento.EquipamentoPO;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "exercicio" )
public class ExercicioPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "nome", length = 60 )
	private String nome;

	@ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY )
	@JoinColumn( name = "id_equipamento", nullable = true )
	private EquipamentoPO equipamento;

	public ExercicioPO(){}

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
	 * Método responsável por retornar o valor do atributo nome.
	 * 
	 * @return String nome - nome a ser retornado(a).
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo nome.
	 * 
	 * @param String nome - nome a ser atribuido(a).
	 */
	public void setNome( String nome ) {
		this.nome = nome;
	}

	/**
	 * Método responsável por retornar o valor do atributo equipamento.
	 * 
	 * @return EquipamentoPO equipamento - equipamento a ser retornado(a).
	 */
	public EquipamentoPO getEquipamento() {
		return equipamento;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo equipamento.
	 * 
	 * @param EquipamentoPO equipamento - equipamento a ser atribuido(a).
	 */
	public void setEquipamento( EquipamentoPO equipamento ) {
		this.equipamento = equipamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( equipamento == null ) ? 0 : equipamento.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
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
		ExercicioPO other = (ExercicioPO) obj;
		if ( equipamento == null ) {
			if ( other.equipamento != null ) {
				return false;
			}
		} else if ( !equipamento.equals( other.equipamento ) ) {
			return false;
		}
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		if ( nome == null ) {
			if ( other.nome != null ) {
				return false;
			}
		} else if ( !nome.equals( other.nome ) ) {
			return false;
		}
		return true;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExercicioPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getNome() != null ? "getNome()=" + getNome() + ", " : "" ) + ( getEquipamento() != null ? "getEquipamento()=" + getEquipamento() : "" ) + "]";
	}

}
