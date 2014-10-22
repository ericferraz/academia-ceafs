package br.com.ceafssystem.domain.pessoa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "endereco" )
public class EnderecoPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column( length = 45, nullable = false )
	private String rua;

	@Column( length = 6, nullable = false )
	private String numero;

	@Column( length = 45, nullable = false )
	private String bairro;

	@Column( length = 10, nullable = false )
	private String cep;

	@Column( length = 45, nullable = false )
	private String cidade;

	@Column( length = 2 )
	private String uf;

	public EnderecoPO(){}

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
	 * Método responsável por retornar o valor do atributo rua.
	 * 
	 * @return String rua - rua a ser retornado(a).
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo rua.
	 * 
	 * @param String rua - rua a ser atribuido(a).
	 */
	public void setRua( String rua ) {
		this.rua = rua;
	}

	/**
	 * Método responsável por retornar o valor do atributo numero.
	 * 
	 * @return String numero - numero a ser retornado(a).
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo numero.
	 * 
	 * @param String numero - numero a ser atribuido(a).
	 */
	public void setNumero( String numero ) {
		this.numero = numero;
	}

	/**
	 * Método responsável por retornar o valor do atributo bairro.
	 * 
	 * @return String bairro - bairro a ser retornado(a).
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo bairro.
	 * 
	 * @param String bairro - bairro a ser atribuido(a).
	 */
	public void setBairro( String bairro ) {
		this.bairro = bairro;
	}

	/**
	 * Método responsável por retornar o valor do atributo cep.
	 * 
	 * @return String cep - cep a ser retornado(a).
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo cep.
	 * 
	 * @param String cep - cep a ser atribuido(a).
	 */
	public void setCep( String cep ) {
		this.cep = cep;
	}

	/**
	 * Método responsável por retornar o valor do atributo cidade.
	 * 
	 * @return String cidade - cidade a ser retornado(a).
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo cidade.
	 * 
	 * @param String cidade - cidade a ser atribuido(a).
	 */
	public void setCidade( String cidade ) {
		this.cidade = cidade;
	}

	/**
	 * Método responsável por retornar o valor do atributo uf.
	 * 
	 * @return String uf - uf a ser retornado(a).
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo uf.
	 * 
	 * @param String uf - uf a ser atribuido(a).
	 */
	public void setUf( String uf ) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( bairro == null ) ? 0 : bairro.hashCode() );
		result = prime * result + ( ( cep == null ) ? 0 : cep.hashCode() );
		result = prime * result + ( ( cidade == null ) ? 0 : cidade.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( numero == null ) ? 0 : numero.hashCode() );
		result = prime * result + ( ( rua == null ) ? 0 : rua.hashCode() );
		result = prime * result + ( ( uf == null ) ? 0 : uf.hashCode() );
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
		EnderecoPO other = (EnderecoPO) obj;
		if ( bairro == null ) {
			if ( other.bairro != null ) {
				return false;
			}
		} else if ( !bairro.equals( other.bairro ) ) {
			return false;
		}
		if ( cep == null ) {
			if ( other.cep != null ) {
				return false;
			}
		} else if ( !cep.equals( other.cep ) ) {
			return false;
		}
		if ( cidade == null ) {
			if ( other.cidade != null ) {
				return false;
			}
		} else if ( !cidade.equals( other.cidade ) ) {
			return false;
		}
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		if ( numero == null ) {
			if ( other.numero != null ) {
				return false;
			}
		} else if ( !numero.equals( other.numero ) ) {
			return false;
		}
		if ( rua == null ) {
			if ( other.rua != null ) {
				return false;
			}
		} else if ( !rua.equals( other.rua ) ) {
			return false;
		}
		if ( uf == null ) {
			if ( other.uf != null ) {
				return false;
			}
		} else if ( !uf.equals( other.uf ) ) {
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
		return "EnderecoPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getRua() != null ? "getRua()=" + getRua() + ", " : "" ) + ( getNumero() != null ? "getNumero()=" + getNumero() + ", " : "" ) + ( getBairro() != null ? "getBairro()=" + getBairro() + ", " : "" ) + ( getCep() != null ? "getCep()=" + getCep() + ", " : "" ) + ( getCidade() != null ? "getCidade()=" + getCidade() + ", " : "" ) + ( getUf() != null ? "getUf()=" + getUf() : "" ) + "]";
	}

}
