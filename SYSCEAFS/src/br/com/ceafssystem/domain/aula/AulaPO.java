package br.com.ceafssystem.domain.aula;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ceafssystem.domain.atividade.AtividadePO;
import br.com.ceafssystem.domain.pessoa.InstrutorPO;

@Entity
@Table( name = "aula" )
public class AulaPO{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "data_aula", nullable = false )
	@Temporal( TemporalType.DATE )
	private Date dataAula;
	
	@Column( name = "pressao_inicial")
	private String pressaoInicial;

	@Column( name = "pressao_final")
	private String pressaoFinal;
	
	@ManyToOne
	@JoinColumn( name = "id_atividade", nullable = false )
	private AtividadePO atividade;

	@ManyToOne
	@JoinColumn( name = "id_instrutor", nullable = false )
	private InstrutorPO instrutor;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_aula", nullable = false )
	private List< AulaExercicioPO > aulaExercicios;

	public AulaPO(){}

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
	 * Método responsável por retornar o valor do atributo dataAula.
	 * 
	 * @return Date dataAula - dataAula a ser retornado(a).
	 */
	public Date getDataAula() {
		return dataAula;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo dataAula.
	 * 
	 * @param Date dataAula - dataAula a ser atribuido(a).
	 */
	public void setDataAula( Date dataAula ) {
		this.dataAula = dataAula;
	}

	/**
	 * Método responsável por retornar o valor do atributo atividade.
	 * 
	 * @return AtividadePO atividade - atividade a ser retornado(a).
	 */
	public AtividadePO getAtividade() {
		return atividade;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo atividade.
	 * 
	 * @param AtividadePO atividade - atividade a ser atribuido(a).
	 */
	public void setAtividade( AtividadePO atividade ) {
		this.atividade = atividade;
	}

	/**
	 * Método responsável por retornar o valor do atributo instrutor.
	 * 
	 * @return InstrutorPO instrutor - instrutor a ser retornado(a).
	 */
	public InstrutorPO getInstrutor() {
		return instrutor;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo instrutor.
	 * 
	 * @param InstrutorPO instrutor - instrutor a ser atribuido(a).
	 */
	public void setInstrutor( InstrutorPO instrutor ) {
		this.instrutor = instrutor;
	}

	public List< AulaExercicioPO > getAulaExercicios() {
		return aulaExercicios;
	}

	public void setAulaExercicios( List< AulaExercicioPO > aulaExercicios ) {
		this.aulaExercicios = aulaExercicios;
	}

	public String getPressaoInicial() {
		return pressaoInicial;
	}

	public void setPressaoInicial( String pressaoInicial ) {
		this.pressaoInicial = pressaoInicial;
	}

	public String getPressaoFinal() {
		return pressaoFinal;
	}

	public void setPressaoFinal( String pressaoFinal ) {
		this.pressaoFinal = pressaoFinal;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AulaPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getDataAula() != null ? "getDataAula()=" + getDataAula() + ", " : "" ) + ( getAtividade() != null ? "getAtividade()=" + getAtividade() + ", " : "" ) + ( getInstrutor() != null ? "getInstrutor()=" + getInstrutor() + ", " : "" ) + ( getAulaExercicios() != null ? "getAulaExercicios()=" + getAulaExercicios() : "" ) + "]";
	}

}
