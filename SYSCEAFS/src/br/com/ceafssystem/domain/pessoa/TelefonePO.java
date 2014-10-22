package br.com.ceafssystem.domain.pessoa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "telefone" )
public class TelefonePO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "ddd" )
	private Byte ddd;

	@Column( name = "numero", nullable = false )
	private String numero;

	private String operadora;

	public TelefonePO(){}

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
	 * Método responsável por retornar o valor do atributo ddd.
	 * 
	 * @return Byte ddd - ddd a ser retornado(a).
	 */
	public Byte getDdd() {
		return ddd;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo ddd.
	 * 
	 * @param Byte ddd - ddd a ser atribuido(a).
	 */
	public void setDdd( Byte ddd ) {
		this.ddd = ddd;
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
	 * Método responsável por retornar o valor do atributo operadora.
	 * 
	 * @return String operadora - operadora a ser retornado(a).
	 */
	public String getOperadora() {
		return operadora;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo operadora.
	 * 
	 * @param String operadora - operadora a ser atribuido(a).
	 */
	public void setOperadora( String operadora ) {
		this.operadora = operadora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( ddd == null ) ? 0 : ddd.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( numero == null ) ? 0 : numero.hashCode() );
		result = prime * result + ( ( operadora == null ) ? 0 : operadora.hashCode() );
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
		TelefonePO other = (TelefonePO) obj;
		if ( ddd == null ) {
			if ( other.ddd != null ) {
				return false;
			}
		} else if ( !ddd.equals( other.ddd ) ) {
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
		if ( operadora == null ) {
			if ( other.operadora != null ) {
				return false;
			}
		} else if ( !operadora.equals( other.operadora ) ) {
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
		return "TelefonePO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getDdd() != null ? "getDdd()=" + getDdd() + ", " : "" ) + ( getNumero() != null ? "getNumero()=" + getNumero() + ", " : "" ) + ( getOperadora() != null ? "getOperadora()=" + getOperadora() : "" ) + "]";
	}

}
