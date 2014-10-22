package br.com.ceafssystem.domain.pessoa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "funcionario" )
public class FuncionarioPO extends PessoaPO implements Serializable{

	@Column( name = "cref", nullable = false )
	private String cref;

	@OneToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_usuario", nullable = false )
	private UsuarioPO usuario;

	public FuncionarioPO(){}

	/**
	 * Método responsável por retornar o valor do atributo cref.
	 * 
	 * @return String cref - cref a ser retornado(a).
	 */
	public String getCref() {
		return cref;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo cref.
	 * 
	 * @param String cref - cref a ser atribuido(a).
	 */
	public void setCref( String cref ) {
		this.cref = cref;
	}

	/**
	 * Método responsável por retornar o valor do atributo usuario.
	 * 
	 * @return UsuarioPO usuario - usuario a ser retornado(a).
	 */
	public UsuarioPO getUsuario() {
		return usuario;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo usuario.
	 * 
	 * @param UsuarioPO usuario - usuario a ser atribuido(a).
	 */
	public void setUsuario( UsuarioPO usuario ) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( cref == null ) ? 0 : cref.hashCode() );
		result = prime * result + ( ( usuario == null ) ? 0 : usuario.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( !super.equals( obj ) ) {
			return false;
		}
		if ( getClass() != obj.getClass() ) {
			return false;
		}
		FuncionarioPO other = (FuncionarioPO) obj;
		if ( cref == null ) {
			if ( other.cref != null ) {
				return false;
			}
		} else if ( !cref.equals( other.cref ) ) {
			return false;
		}
		if ( usuario == null ) {
			if ( other.usuario != null ) {
				return false;
			}
		} else if ( !usuario.equals( other.usuario ) ) {
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
		return "FuncionarioPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getCref() != null ? "getCref()=" + getCref() + ", " : "" ) + ( getUsuario() != null ? "getUsuario()=" + getUsuario() : "" ) + "]";
	}

}
