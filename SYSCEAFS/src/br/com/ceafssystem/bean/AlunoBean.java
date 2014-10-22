package br.com.ceafssystem.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import br.com.ceafssystem.controller.aluno.AlunoFacade;
import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.EnderecoPO;
import br.com.ceafssystem.domain.pessoa.PessoaPO;
import br.com.ceafssystem.domain.pessoa.TelefonePO;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 * 
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 31/03/2014 00:47:57
 * @version 1.0
 */
@ManagedBean( name = "MBAluno" )
@ViewScoped
public class AlunoBean{
	private AlunoPO aluno;
	private PessoaPO pessoa;
	private EnderecoPO endereco;
	private TelefonePO telefone = new TelefonePO();
	private List< TelefonePO > telefones = new ArrayList< TelefonePO >();
	private ArrayList< AlunoPO > itens;
	private ArrayList< AlunoPO > itensFiltrados;

	public AlunoPO getAluno() {
		return aluno;
	}

	public void setAluno( AlunoPO aluno ) {
		this.aluno = aluno;
	}

	public PessoaPO getPessoa() {
		return pessoa;
	}

	public void setPessoa( PessoaPO pessoa ) {
		this.pessoa = pessoa;
	}

	public EnderecoPO getEndereco() {
		return endereco;
	}

	public void setEndereco( EnderecoPO endereco ) {
		this.endereco = endereco;
	}

	public TelefonePO getTelefone() {
		return telefone;
	}

	public void setTelefone( TelefonePO telefone ) {
		this.telefone = telefone;
	}

	public List< TelefonePO > getTelefones() {
		return telefones;
	}

	public void setTelefones( List< TelefonePO > telefones ) {
		this.telefones = telefones;
	}

	public ArrayList< AlunoPO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< AlunoPO > itens ) {
		this.itens = itens;
	}

	public ArrayList< AlunoPO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< AlunoPO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public void prepararNovo() {
		endereco = new EnderecoPO();
		pessoa = new PessoaPO();
		pessoa.setEndereco( endereco );
		// Eu seto aqui pra não correr o risco de não ligar os dois
		pessoa.setTelefones( telefones );
		aluno = new AlunoPO();
		aluno.setPessoa( pessoa );
	}

	public void adicionarTelefone() {
		carregarTelefones();
		telefones.add( telefone );
		// Preciso dessa instância pois do contrário o formulário não é limpo ao
		// adicionar um novo telefone (objeto corrente continua na tela)
		telefone = new TelefonePO();
	}

	public void removerTelefone( TelefonePO telefone ) {
		carregarTelefones();
		List< TelefonePO > pesquisarTelefone = aluno.getPessoa().getTelefones();
		TelefonePO telefoneExclusao = new TelefonePO();
		for ( TelefonePO telefonePO : pesquisarTelefone ) {
	        if(telefone.getId() == telefonePO.getId() ){
	        	telefoneExclusao = telefonePO;
	        }
        }
		
		telefones.remove( telefoneExclusao );
		aluno.getPessoa().setTelefones( telefones );
		AlunoFacade.getInstance().alterar( aluno );
		JSFUtil.adicionarMensagemSucesso( "Telefone excluído com sucesso." );
		prepararPesquisa();
	}

	public void gravarTelefones() {
		carregarTelefones(); // Se não tiver essa linha dá erro ao apertar o botão com os campos do fone preenchidos
		aluno.getPessoa().setTelefones( telefones );
		AlunoFacade.getInstance().alterar( aluno );
		JSFUtil.adicionarMensagemSucesso( "Telefone(s) salvo(s) com sucesso." );
		prepararPesquisa();
	}

	public void carregarTelefones() {
		telefones = aluno.getPessoa().getTelefones();
	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		AlunoPO po = new AlunoPO();

		itens = (ArrayList< AlunoPO >) AlunoFacade.getInstance().filtrar( po );

	}

	public void novo() {

		try {
			AlunoFacade.getInstance().salvar( aluno );

			JSFUtil.adicionarMensagemSucesso( "Aluno salvo com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

	public void excluir() {

		try {
			AlunoFacade.getInstance().excluir( aluno );

			JSFUtil.adicionarMensagemSucesso( "Aluno excluído com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}

	}

	public void editar() {

		try {
			AlunoFacade.getInstance().alterar( aluno );

			JSFUtil.adicionarMensagemSucesso( "Aluno editado com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

}
