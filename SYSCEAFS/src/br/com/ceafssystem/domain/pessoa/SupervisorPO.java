package br.com.ceafssystem.domain.pessoa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "supervisor" )
public class SupervisorPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_funcionario", nullable = false )
	private FuncionarioPO funcionario;

	public SupervisorPO(){}

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
	 * Método responsável por retornar o valor do atributo funcionario.
	 * 
	 * @return FuncionarioPO funcionario - funcionario a ser retornado(a).
	 */
	public FuncionarioPO getFuncionario() {
		return funcionario;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo funcionario.
	 * 
	 * @param FuncionarioPO funcionario - funcionario a ser atribuido(a).
	 */
	public void setFuncionario( FuncionarioPO funcionario ) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( funcionario == null ) ? 0 : funcionario.hashCode() );
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
		SupervisorPO other = (SupervisorPO) obj;
		if ( funcionario == null ) {
			if ( other.funcionario != null ) {
				return false;
			}
		} else if ( !funcionario.equals( other.funcionario ) ) {
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

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SupervisorPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getFuncionario() != null ? "getFuncionario()=" + getFuncionario() : "" ) + "]";
	}

}
