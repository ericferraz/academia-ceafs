package br.com.ceafssystem.domain.pessoa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "usuario" )
public class UsuarioPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "login", nullable = false )
	private String login;

	@Column( name = "senha", nullable = false )
	private String senha;

	private String tipoUsuario;

	public UsuarioPO(){}

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
	 * Método responsável por retornar o valor do atributo login.
	 * 
	 * @return String login - login a ser retornado(a).
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo login.
	 * 
	 * @param String login - login a ser atribuido(a).
	 */
	public void setLogin( String login ) {
		this.login = login;
	}

	/**
	 * Método responsável por retornar o valor do atributo senha.
	 * 
	 * @return String senha - senha a ser retornado(a).
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo senha.
	 * 
	 * @param String senha - senha a ser atribuido(a).
	 */
	public void setSenha( String senha ) {
		this.senha = senha;
	}

	/**
	 * Método responsável por retornar o valor do atributo tipoUsuario.
	 * 
	 * @return String tipoUsuario - tipoUsuario a ser retornado(a).
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo tipoUsuario.
	 * 
	 * @param String tipoUsuario - tipoUsuario a ser atribuido(a).
	 */
	public void setTipoUsuario( String tipoUsuario ) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( login == null ) ? 0 : login.hashCode() );
		result = prime * result + ( ( senha == null ) ? 0 : senha.hashCode() );
		result = prime * result + ( ( tipoUsuario == null ) ? 0 : tipoUsuario.hashCode() );
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
		UsuarioPO other = (UsuarioPO) obj;
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		if ( login == null ) {
			if ( other.login != null ) {
				return false;
			}
		} else if ( !login.equals( other.login ) ) {
			return false;
		}
		if ( senha == null ) {
			if ( other.senha != null ) {
				return false;
			}
		} else if ( !senha.equals( other.senha ) ) {
			return false;
		}
		if ( tipoUsuario == null ) {
			if ( other.tipoUsuario != null ) {
				return false;
			}
		} else if ( !tipoUsuario.equals( other.tipoUsuario ) ) {
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
		return "UsuarioPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getLogin() != null ? "getLogin()=" + getLogin() + ", " : "" ) + ( getSenha() != null ? "getSenha()=" + getSenha() + ", " : "" ) + ( getTipoUsuario() != null ? "getTipoUsuario()=" + getTipoUsuario() : "" ) + "]";
	}

}
