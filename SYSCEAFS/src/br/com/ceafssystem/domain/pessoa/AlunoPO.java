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
@Table( name = "aluno" )
public class AlunoPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	private String profissao;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_pessoa", nullable = false )
	private PessoaPO pessoa;

	public AlunoPO(){}

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
	 * Método responsável por retornar o valor do atributo profissao.
	 * 
	 * @return String profissao - profissao a ser retornado(a).
	 */
	public String getProfissao() {
		return profissao;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo profissao.
	 * 
	 * @param String profissao - profissao a ser atribuido(a).
	 */
	public void setProfissao( String profissao ) {
		this.profissao = profissao;
	}

	/**
	 * Método responsável por retornar o valor do atributo pessoa.
	 * 
	 * @return PessoaPO pessoa - pessoa a ser retornado(a).
	 */
	public PessoaPO getPessoa() {
		return pessoa;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo pessoa.
	 * 
	 * @param PessoaPO pessoa - pessoa a ser atribuido(a).
	 */
	public void setPessoa( PessoaPO pessoa ) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( pessoa == null ) ? 0 : pessoa.hashCode() );
		result = prime * result + ( ( profissao == null ) ? 0 : profissao.hashCode() );
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
		AlunoPO other = (AlunoPO) obj;
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		if ( pessoa == null ) {
			if ( other.pessoa != null ) {
				return false;
			}
		} else if ( !pessoa.equals( other.pessoa ) ) {
			return false;
		}
		if ( profissao == null ) {
			if ( other.profissao != null ) {
				return false;
			}
		} else if ( !profissao.equals( other.profissao ) ) {
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
		return "AlunoPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getProfissao() != null ? "getProfissao()=" + getProfissao() + ", " : "" ) + ( getPessoa() != null ? "getPessoa()=" + getPessoa() : "" ) + "]";
	}

}
