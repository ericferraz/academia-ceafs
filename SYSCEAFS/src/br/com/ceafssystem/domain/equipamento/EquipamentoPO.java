package br.com.ceafssystem.domain.equipamento;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "equipamento" )
public class EquipamentoPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column( nullable = false )
	private String nome;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "id_configuracao", nullable = true )
	private ConfiguracaoPO configuracao;

	public EquipamentoPO(){}

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
	 * Método responsável por retornar o valor do atributo configuracao.
	 * 
	 * @return ConfiguracaoPO configuracao - configuracao a ser retornado(a).
	 */
	public ConfiguracaoPO getConfiguracao() {
		return configuracao;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo configuracao.
	 * 
	 * @param ConfiguracaoPO configuracao - configuracao a ser atribuido(a).
	 */
	public void setConfiguracao( ConfiguracaoPO configuracao ) {
		this.configuracao = configuracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( configuracao == null ) ? 0 : configuracao.hashCode() );
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
		EquipamentoPO other = (EquipamentoPO) obj;
		if ( configuracao == null ) {
			if ( other.configuracao != null ) {
				return false;
			}
		} else if ( !configuracao.equals( other.configuracao ) ) {
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
		return "EquipamentoPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getNome() != null ? "getNome()=" + getNome() + ", " : "" ) + ( getConfiguracao() != null ? "getConfiguracao()=" + getConfiguracao() : "" ) + "]";
	}

}
