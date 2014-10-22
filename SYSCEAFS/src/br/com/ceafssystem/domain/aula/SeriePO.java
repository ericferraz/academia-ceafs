package br.com.ceafssystem.domain.aula;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table( name = "serie" )
public class SeriePO{

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	@Column( name = "carga_direita" )
	private String cargaDireita;

	@Column( name = "carga_esquerda" )
	private String cargaEsquerda;

	@ManyToOne( cascade = { CascadeType.ALL }, fetch = FetchType.EAGER )
	@JoinColumn( name = "id_aula_exercicio", nullable = true )
	private AulaExercicioPO aulaExercicio;

	@Column( name = "id_aluno", nullable = true )
	private Long alunoSerie;

	@Column( name = "data_aula" )
	@Temporal( TemporalType.DATE )
	private Date dataAula;
	
	@Transient
	private Boolean situacao;

	public SeriePO(){}

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
	 * Método responsável por retornar o valor do atributo descricao.
	 * 
	 * @return String descricao - descricao a ser retornado(a).
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo descricao.
	 * 
	 * @param String descricao - descricao a ser atribuido(a).
	 */
	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	/**
	 * Método responsável por retornar o valor do atributo cargaDireita.
	 * 
	 * @return String cargaDireita - cargaDireita a ser retornado(a).
	 */
	public String getCargaDireita() {
		return cargaDireita;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo cargaDireita.
	 * 
	 * @param String cargaDireita - cargaDireita a ser atribuido(a).
	 */
	public void setCargaDireita( String cargaDireita ) {
		this.cargaDireita = cargaDireita;
	}

	/**
	 * Método responsável por retornar o valor do atributo cargaEsquerda.
	 * 
	 * @return String cargaEsquerda - cargaEsquerda a ser retornado(a).
	 */
	public String getCargaEsquerda() {
		return cargaEsquerda;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo cargaEsquerda.
	 * 
	 * @param String cargaEsquerda - cargaEsquerda a ser atribuido(a).
	 */
	public void setCargaEsquerda( String cargaEsquerda ) {
		this.cargaEsquerda = cargaEsquerda;
	}

	public AulaExercicioPO getAulaExercicio() {
		return aulaExercicio;
	}

	public void setAulaExercicio( AulaExercicioPO aulaExercicio ) {
		this.aulaExercicio = aulaExercicio;
	}

	public Long getAlunoSerie() {
		return alunoSerie;
	}

	public void setAlunoSerie( Long alunoSerie ) {
		this.alunoSerie = alunoSerie;
	}

	public Date getDataAula() {
		return dataAula;
	}

	public void setDataAula( Date dataAula ) {
		this.dataAula = dataAula;
	}
	
	public Boolean getSituacao() {
	    return situacao;
    }
	
	public void setSituacao( Boolean situacao ) {
	    this.situacao = situacao;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( alunoSerie == null ) ? 0 : alunoSerie.hashCode() );
		result = prime * result + ( ( aulaExercicio == null ) ? 0 : aulaExercicio.hashCode() );
		result = prime * result + ( ( cargaDireita == null ) ? 0 : cargaDireita.hashCode() );
		result = prime * result + ( ( cargaEsquerda == null ) ? 0 : cargaEsquerda.hashCode() );
		result = prime * result + ( ( dataAula == null ) ? 0 : dataAula.hashCode() );
		result = prime * result + ( ( descricao == null ) ? 0 : descricao.hashCode() );
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
		SeriePO other = (SeriePO) obj;
		if ( alunoSerie == null ) {
			if ( other.alunoSerie != null ) {
				return false;
			}
		} else if ( !alunoSerie.equals( other.alunoSerie ) ) {
			return false;
		}
		if ( aulaExercicio == null ) {
			if ( other.aulaExercicio != null ) {
				return false;
			}
		} else if ( !aulaExercicio.equals( other.aulaExercicio ) ) {
			return false;
		}
		if ( cargaDireita == null ) {
			if ( other.cargaDireita != null ) {
				return false;
			}
		} else if ( !cargaDireita.equals( other.cargaDireita ) ) {
			return false;
		}
		if ( cargaEsquerda == null ) {
			if ( other.cargaEsquerda != null ) {
				return false;
			}
		} else if ( !cargaEsquerda.equals( other.cargaEsquerda ) ) {
			return false;
		}
		if ( dataAula == null ) {
			if ( other.dataAula != null ) {
				return false;
			}
		} else if ( !dataAula.equals( other.dataAula ) ) {
			return false;
		}
		if ( descricao == null ) {
			if ( other.descricao != null ) {
				return false;
			}
		} else if ( !descricao.equals( other.descricao ) ) {
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

	@Override
	public String toString() {
		return "SeriePO [getId()=" + getId() + ", getDescricao()=" + getDescricao() + ", getCargaDireita()=" + getCargaDireita() + ", getCargaEsquerda()=" + getCargaEsquerda() + ", getAulaExercicio()=" + getAulaExercicio() + ", getAlunoSerie()=" + getAlunoSerie() + ", getDataAula()=" + getDataAula() + ", hashCode()=" + hashCode() + "]";
	}

}
