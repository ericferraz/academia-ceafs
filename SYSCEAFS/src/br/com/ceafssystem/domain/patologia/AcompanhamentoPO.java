package br.com.ceafssystem.domain.patologia;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ceafssystem.domain.pessoa.AlunoPO;

@Entity
@Table( name = "acompanhamento" )
public class AcompanhamentoPO{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "data_preenchimento", nullable = false )
	private Date dataPreenchimento;

	@Column( name = "data_ultimo_exame" )
	private Date dataUltimoExame;

	@OneToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_aluno", nullable = false )
	private AlunoPO aluno;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "id_acompanhamento", nullable = false )
	private List< AcompanhamentoPatologiaPO > acompanhamentoPatologias;

	public AcompanhamentoPO(){}

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
	 * Método responsável por retornar o valor do atributo dataPreenchimento.
	 * 
	 * @return Date dataPreenchimento - dataPreenchimento a ser retornado(a).
	 */
	public Date getDataPreenchimento() {
		return dataPreenchimento;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo dataPreenchimento.
	 * 
	 * @param Date dataPreenchimento - dataPreenchimento a ser atribuido(a).
	 */
	public void setDataPreenchimento( Date dataPreenchimento ) {
		this.dataPreenchimento = dataPreenchimento;
	}

	/**
	 * Método responsável por retornar o valor do atributo dataUltimoExame.
	 * 
	 * @return Date dataUltimoExame - dataUltimoExame a ser retornado(a).
	 */
	public Date getDataUltimoExame() {
		return dataUltimoExame;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo dataUltimoExame.
	 * 
	 * @param Date dataUltimoExame - dataUltimoExame a ser atribuido(a).
	 */
	public void setDataUltimoExame( Date dataUltimoExame ) {
		this.dataUltimoExame = dataUltimoExame;
	}

	/**
	 * Método responsável por retornar o valor do atributo aluno.
	 * 
	 * @return AlunoPO aluno - aluno a ser retornado(a).
	 */
	public AlunoPO getAluno() {
		return aluno;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo aluno.
	 * 
	 * @param AlunoPO aluno - aluno a ser atribuido(a).
	 */
	public void setAluno( AlunoPO aluno ) {
		this.aluno = aluno;
	}

	/**
	 * Método responsável por retornar o valor do atributo acompanhamentoPatologias.
	 * 
	 * @return Set<AcompanhamentoPatologiaPO> acompanhamentoPatologias - acompanhamentoPatologias a ser retornado(a).
	 */
	public List< AcompanhamentoPatologiaPO > getAcompanhamentoPatologias() {
		return acompanhamentoPatologias;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo acompanhamentoPatologias.
	 * 
	 * @param Set<AcompanhamentoPatologiaPO> acompanhamentoPatologias - acompanhamentoPatologias a ser atribuido(a).
	 */
	public void setAcompanhamentoPatologias( List< AcompanhamentoPatologiaPO > acompanhamentoPatologias ) {
		this.acompanhamentoPatologias = acompanhamentoPatologias;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AcompanhamentoPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getDataPreenchimento() != null ? "getDataPreenchimento()=" + getDataPreenchimento() + ", " : "" ) + ( getDataUltimoExame() != null ? "getDataUltimoExame()=" + getDataUltimoExame() + ", " : "" ) + ( getAluno() != null ? "getAluno()=" + getAluno() + ", " : "" ) + ( getAcompanhamentoPatologias() != null ? "getAcompanhamentoPatologias()=" + getAcompanhamentoPatologias() : "" ) + "]";
	}

}
