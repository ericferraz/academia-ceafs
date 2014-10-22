package br.com.ceafssystem.domain.equipamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "configuracao" )
public class ConfiguracaoPO{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "altura_minima" )
	private Float alturaMinima;

	@Column( name = "altura_maxima" )
	private Float alturaMaxima;

	@Column( name = "amplitude_minima" )
	private Float amplitudeMinima;

	@Column( name = "amplitude_maxima" )
	private Float amplitudeMaxima;

	@Column( name = "encosto_minimo" )
	private Float encostoMinimo;

	@Column( name = "encosto_maximo" )
	private Float encostoMaximo;

	public ConfiguracaoPO(){}

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
	 * Método responsável por retornar o valor do atributo alturaMinima.
	 * 
	 * @return Float alturaMinima - alturaMinima a ser retornado(a).
	 */
	public Float getAlturaMinima() {
		return alturaMinima;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo alturaMinima.
	 * 
	 * @param Float alturaMinima - alturaMinima a ser atribuido(a).
	 */
	public void setAlturaMinima( Float alturaMinima ) {
		this.alturaMinima = alturaMinima;
	}

	/**
	 * Método responsável por retornar o valor do atributo alturaMaxima.
	 * 
	 * @return Float alturaMaxima - alturaMaxima a ser retornado(a).
	 */
	public Float getAlturaMaxima() {
		return alturaMaxima;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo alturaMaxima.
	 * 
	 * @param Float alturaMaxima - alturaMaxima a ser atribuido(a).
	 */
	public void setAlturaMaxima( Float alturaMaxima ) {
		this.alturaMaxima = alturaMaxima;
	}

	/**
	 * Método responsável por retornar o valor do atributo amplitudeMinima.
	 * 
	 * @return Float amplitudeMinima - amplitudeMinima a ser retornado(a).
	 */
	public Float getAmplitudeMinima() {
		return amplitudeMinima;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo amplitudeMinima.
	 * 
	 * @param Float amplitudeMinima - amplitudeMinima a ser atribuido(a).
	 */
	public void setAmplitudeMinima( Float amplitudeMinima ) {
		this.amplitudeMinima = amplitudeMinima;
	}

	/**
	 * Método responsável por retornar o valor do atributo amplitudeMaxima.
	 * 
	 * @return Float amplitudeMaxima - amplitudeMaxima a ser retornado(a).
	 */
	public Float getAmplitudeMaxima() {
		return amplitudeMaxima;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo amplitudeMaxima.
	 * 
	 * @param Float amplitudeMaxima - amplitudeMaxima a ser atribuido(a).
	 */
	public void setAmplitudeMaxima( Float amplitudeMaxima ) {
		this.amplitudeMaxima = amplitudeMaxima;
	}

	/**
	 * Método responsável por retornar o valor do atributo encostoMinimo.
	 * 
	 * @return Float encostoMinimo - encostoMinimo a ser retornado(a).
	 */
	public Float getEncostoMinimo() {
		return encostoMinimo;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo encostoMinimo.
	 * 
	 * @param Float encostoMinimo - encostoMinimo a ser atribuido(a).
	 */
	public void setEncostoMinimo( Float encostoMinimo ) {
		this.encostoMinimo = encostoMinimo;
	}

	/**
	 * Método responsável por retornar o valor do atributo encostoMaximo.
	 * 
	 * @return Float encostoMaximo - encostoMaximo a ser retornado(a).
	 */
	public Float getEncostoMaximo() {
		return encostoMaximo;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo encostoMaximo.
	 * 
	 * @param Float encostoMaximo - encostoMaximo a ser atribuido(a).
	 */
	public void setEncostoMaximo( Float encostoMaximo ) {
		this.encostoMaximo = encostoMaximo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( alturaMaxima == null ) ? 0 : alturaMaxima.hashCode() );
		result = prime * result + ( ( alturaMinima == null ) ? 0 : alturaMinima.hashCode() );
		result = prime * result + ( ( amplitudeMaxima == null ) ? 0 : amplitudeMaxima.hashCode() );
		result = prime * result + ( ( amplitudeMinima == null ) ? 0 : amplitudeMinima.hashCode() );
		result = prime * result + ( ( encostoMaximo == null ) ? 0 : encostoMaximo.hashCode() );
		result = prime * result + ( ( encostoMinimo == null ) ? 0 : encostoMinimo.hashCode() );
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
		ConfiguracaoPO other = (ConfiguracaoPO) obj;
		if ( alturaMaxima == null ) {
			if ( other.alturaMaxima != null ) {
				return false;
			}
		} else if ( !alturaMaxima.equals( other.alturaMaxima ) ) {
			return false;
		}
		if ( alturaMinima == null ) {
			if ( other.alturaMinima != null ) {
				return false;
			}
		} else if ( !alturaMinima.equals( other.alturaMinima ) ) {
			return false;
		}
		if ( amplitudeMaxima == null ) {
			if ( other.amplitudeMaxima != null ) {
				return false;
			}
		} else if ( !amplitudeMaxima.equals( other.amplitudeMaxima ) ) {
			return false;
		}
		if ( amplitudeMinima == null ) {
			if ( other.amplitudeMinima != null ) {
				return false;
			}
		} else if ( !amplitudeMinima.equals( other.amplitudeMinima ) ) {
			return false;
		}
		if ( encostoMaximo == null ) {
			if ( other.encostoMaximo != null ) {
				return false;
			}
		} else if ( !encostoMaximo.equals( other.encostoMaximo ) ) {
			return false;
		}
		if ( encostoMinimo == null ) {
			if ( other.encostoMinimo != null ) {
				return false;
			}
		} else if ( !encostoMinimo.equals( other.encostoMinimo ) ) {
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
		return "ConfiguracaoPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getAlturaMinima() != null ? "getAlturaMinima()=" + getAlturaMinima() + ", " : "" ) + ( getAlturaMaxima() != null ? "getAlturaMaxima()=" + getAlturaMaxima() + ", " : "" ) + ( getAmplitudeMinima() != null ? "getAmplitudeMinima()=" + getAmplitudeMinima() + ", " : "" ) + ( getAmplitudeMaxima() != null ? "getAmplitudeMaxima()=" + getAmplitudeMaxima() + ", " : "" ) + ( getEncostoMinimo() != null ? "getEncostoMinimo()=" + getEncostoMinimo() + ", " : "" ) + ( getEncostoMaximo() != null ? "getEncostoMaximo()=" + getEncostoMaximo() : "" ) + "]";
	}

}
