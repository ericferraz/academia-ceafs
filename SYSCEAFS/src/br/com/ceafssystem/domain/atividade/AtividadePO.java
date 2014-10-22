package br.com.ceafssystem.domain.atividade;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.SupervisorPO;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "atividade" )
public class AtividadePO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_supervisor", nullable = false )
	private SupervisorPO supervisor;

	@ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_aluno", nullable = false )
	private AlunoPO aluno;

	@Column( name = "dia_da_semana", nullable = false )
	private String diaDaSemana;

	@Column( name = "hora", nullable = false )
	@Temporal( TemporalType.TIME )
	private Date hora;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_atividade", nullable = false )
	private List< AtividadeExercicioPO > atividadeExercicios;

	public AtividadePO(){}

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
	 * Método responsável por retornar o valor do atributo supervisor.
	 * 
	 * @return SupervisorPO supervisor - supervisor a ser retornado(a).
	 */
	public SupervisorPO getSupervisor() {
		return supervisor;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo supervisor.
	 * 
	 * @param SupervisorPO supervisor - supervisor a ser atribuido(a).
	 */
	public void setSupervisor( SupervisorPO supervisor ) {
		this.supervisor = supervisor;
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
	 * Método responsável por retornar o valor do atributo diaDaSemana.
	 * 
	 * @return String diaDaSemana - diaDaSemana a ser retornado(a).
	 */
	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo diaDaSemana.
	 * 
	 * @param String diaDaSemana - diaDaSemana a ser atribuido(a).
	 */
	public void setDiaDaSemana( String diaDaSemana ) {
		this.diaDaSemana = diaDaSemana;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora( Date hora ) {
		this.hora = hora;
	}

	public List< AtividadeExercicioPO > getAtividadeExercicios() {
		return atividadeExercicios;
	}

	public void setAtividadeExercicios( List< AtividadeExercicioPO > atividadeExercicios ) {
		this.atividadeExercicios = atividadeExercicios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( aluno == null ) ? 0 : aluno.hashCode() );
		result = prime * result + ( ( atividadeExercicios == null ) ? 0 : atividadeExercicios.hashCode() );
		result = prime * result + ( ( diaDaSemana == null ) ? 0 : diaDaSemana.hashCode() );
		result = prime * result + ( ( hora == null ) ? 0 : hora.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( supervisor == null ) ? 0 : supervisor.hashCode() );
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
		AtividadePO other = (AtividadePO) obj;
		if ( aluno == null ) {
			if ( other.aluno != null ) {
				return false;
			}
		} else if ( !aluno.equals( other.aluno ) ) {
			return false;
		}
		if ( atividadeExercicios == null ) {
			if ( other.atividadeExercicios != null ) {
				return false;
			}
		} else if ( !atividadeExercicios.equals( other.atividadeExercicios ) ) {
			return false;
		}
		if ( diaDaSemana == null ) {
			if ( other.diaDaSemana != null ) {
				return false;
			}
		} else if ( !diaDaSemana.equals( other.diaDaSemana ) ) {
			return false;
		}
		if ( hora == null ) {
			if ( other.hora != null ) {
				return false;
			}
		} else if ( !hora.equals( other.hora ) ) {
			return false;
		}
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
		if ( supervisor == null ) {
			if ( other.supervisor != null ) {
				return false;
			}
		} else if ( !supervisor.equals( other.supervisor ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AtividadePO [getId()=" + getId() + ", getSupervisor()=" + getSupervisor() + ", getAluno()=" + getAluno() + ", getDiaDaSemana()=" + getDiaDaSemana() + ", getAtividadeExercicios()=" + getAtividadeExercicios() + "]";
	}

}
