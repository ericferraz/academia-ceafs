package br.com.ceafssystem.domain.patologia;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "acompanhamento_patologia" )
public class AcompanhamentoPatologiaPO{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "especificacoes" )
	private String especificacoes;

	@Column( name = "situacao", length = 10 )
	private String situacao;

	@OneToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_patologia", nullable = false )
	private PatologiaPO patologia;

	public AcompanhamentoPatologiaPO(){}

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
	 * Método responsável por retornar o valor do atributo especificacoes.
	 * 
	 * @return String especificacoes - especificacoes a ser retornado(a).
	 */
	public String getEspecificacoes() {
		return especificacoes;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo especificacoes.
	 * 
	 * @param String especificacoes - especificacoes a ser atribuido(a).
	 */
	public void setEspecificacoes( String especificacoes ) {
		this.especificacoes = especificacoes;
	}

	/**
	 * Método responsável por retornar o valor do atributo patologia.
	 * 
	 * @return PatologiaPO patologia - patologia a ser retornado(a).
	 */
	public PatologiaPO getPatologia() {
		return patologia;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo patologia.
	 * 
	 * @param PatologiaPO patologia - patologia a ser atribuido(a).
	 */
	public void setPatologia( PatologiaPO patologia ) {
		this.patologia = patologia;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao( String situacao ) {
		this.situacao = situacao;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AcompanhamentoPatologiaPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getEspecificacoes() != null ? "getEspecificacoes()=" + getEspecificacoes() + ", " : "" ) + ( getPatologia() != null ? "getPatologia()=" + getPatologia() : "" ) + "]";
	}

}
