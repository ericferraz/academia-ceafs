package br.com.ceafssystem.domain.pessoa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings( "serial" )
@Entity
@Table( name = "pessoa" )
@Inheritance( strategy = InheritanceType.JOINED )
public class PessoaPO implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "nome", nullable = false )
	private String nome;

	@Column( name = "rg" )
	private String rg;

	@Column( name = "cpf", nullable = false )
	private String cpf;

	private String genero;

	@Column( name = "data_nascimento", nullable = false )
	private String dataNascimento;

	private String email;

	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = "id_endereco", nullable = false )
	private EnderecoPO endereco;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true )
	@JoinColumn( name = "id_pessoa", nullable = true )
	private List< TelefonePO > telefones;

	public PessoaPO(){}

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
	 * Método responsável por retornar o valor do atributo rg.
	 * 
	 * @return String rg - rg a ser retornado(a).
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo rg.
	 * 
	 * @param String rg - rg a ser atribuido(a).
	 */
	public void setRg( String rg ) {
		this.rg = rg;
	}

	/**
	 * Método responsável por retornar o valor do atributo cpf.
	 * 
	 * @return String cpf - cpf a ser retornado(a).
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo cpf.
	 * 
	 * @param String cpf - cpf a ser atribuido(a).
	 */
	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}

	/**
	 * Método responsável por retornar o valor do atributo genero.
	 * 
	 * @return String genero - genero a ser retornado(a).
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo genero.
	 * 
	 * @param String genero - genero a ser atribuido(a).
	 */
	public void setGenero( String genero ) {
		this.genero = genero;
	}

	/**
	 * Método responsável por retornar o valor do atributo dataNascimento.
	 * 
	 * @return Date dataNascimento - dataNascimento a ser retornado(a).
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo dataNascimento.
	 * 
	 * @param Date dataNascimento - dataNascimento a ser atribuido(a).
	 */
	public void setDataNascimento( String dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Método responsável por retornar o valor do atributo email.
	 * 
	 * @return String email - email a ser retornado(a).
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo email.
	 * 
	 * @param String email - email a ser atribuido(a).
	 */
	public void setEmail( String email ) {
		this.email = email;
	}

	/**
	 * Método responsável por retornar o valor do atributo endereco.
	 * 
	 * @return EnderecoPO endereco - endereco a ser retornado(a).
	 */
	public EnderecoPO getEndereco() {
		return endereco;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo endereco.
	 * 
	 * @param EnderecoPO endereco - endereco a ser atribuido(a).
	 */
	public void setEndereco( EnderecoPO endereco ) {
		this.endereco = endereco;
	}

	/**
	 * Método responsável por retornar o valor do atributo telefones.
	 * 
	 * @return Set<TelefonePO> telefones - telefones a ser retornado(a).
	 */
	public List< TelefonePO > getTelefones() {
		return telefones;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo telefones.
	 * 
	 * @param Set<TelefonePO> telefones - telefones a ser atribuido(a).
	 */
	public void setTelefones( List< TelefonePO > telefones ) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( cpf == null ) ? 0 : cpf.hashCode() );
		result = prime * result + ( ( dataNascimento == null ) ? 0 : dataNascimento.hashCode() );
		result = prime * result + ( ( email == null ) ? 0 : email.hashCode() );
		result = prime * result + ( ( endereco == null ) ? 0 : endereco.hashCode() );
		result = prime * result + ( ( genero == null ) ? 0 : genero.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		result = prime * result + ( ( rg == null ) ? 0 : rg.hashCode() );
		result = prime * result + ( ( telefones == null ) ? 0 : telefones.hashCode() );
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
		PessoaPO other = (PessoaPO) obj;
		if ( cpf == null ) {
			if ( other.cpf != null ) {
				return false;
			}
		} else if ( !cpf.equals( other.cpf ) ) {
			return false;
		}
		if ( dataNascimento == null ) {
			if ( other.dataNascimento != null ) {
				return false;
			}
		} else if ( !dataNascimento.equals( other.dataNascimento ) ) {
			return false;
		}
		if ( email == null ) {
			if ( other.email != null ) {
				return false;
			}
		} else if ( !email.equals( other.email ) ) {
			return false;
		}
		if ( endereco == null ) {
			if ( other.endereco != null ) {
				return false;
			}
		} else if ( !endereco.equals( other.endereco ) ) {
			return false;
		}
		if ( genero == null ) {
			if ( other.genero != null ) {
				return false;
			}
		} else if ( !genero.equals( other.genero ) ) {
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
		if ( rg == null ) {
			if ( other.rg != null ) {
				return false;
			}
		} else if ( !rg.equals( other.rg ) ) {
			return false;
		}
		if ( telefones == null ) {
			if ( other.telefones != null ) {
				return false;
			}
		} else if ( !telefones.equals( other.telefones ) ) {
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
		return "PessoaPO [" + ( getId() != null ? "getId()=" + getId() + ", " : "" ) + ( getNome() != null ? "getNome()=" + getNome() + ", " : "" ) + ( getRg() != null ? "getRg()=" + getRg() + ", " : "" ) + ( getCpf() != null ? "getCpf()=" + getCpf() + ", " : "" ) + ( getGenero() != null ? "getGenero()=" + getGenero() + ", " : "" ) + ( getDataNascimento() != null ? "getDataNascimento()=" + getDataNascimento() + ", " : "" ) + ( getEmail() != null ? "getEmail()=" + getEmail() + ", " : "" ) + ( getEndereco() != null ? "getEndereco()=" + getEndereco() + ", " : "" ) + ( getTelefones() != null ? "getTelefones()=" + getTelefones() : "" ) + "]";
	}

}
