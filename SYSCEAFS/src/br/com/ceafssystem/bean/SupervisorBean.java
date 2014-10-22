package br.com.ceafssystem.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import br.com.ceafssystem.controller.supervisor.SupervisorFacade;
import br.com.ceafssystem.domain.pessoa.EnderecoPO;
import br.com.ceafssystem.domain.pessoa.FuncionarioPO;
import br.com.ceafssystem.domain.pessoa.SupervisorPO;
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
@ManagedBean( name = "MBSupervisor" )
@ViewScoped
public class SupervisorBean{
	private SupervisorPO supervisor;
	private FuncionarioPO funcionario;
	private EnderecoPO endereco;
	private TelefonePO telefone = new TelefonePO();
	private List< TelefonePO > telefones = new ArrayList< TelefonePO >();
	private ArrayList< SupervisorPO > itens;
	private ArrayList< SupervisorPO > itensFiltrados;

	public SupervisorPO getSupervisor() {
		return supervisor;
	}

	public void setSupervisor( SupervisorPO supervisor ) {
		this.supervisor = supervisor;
	}

	public FuncionarioPO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario( FuncionarioPO funcionario ) {
		this.funcionario = funcionario;
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

	public ArrayList< SupervisorPO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< SupervisorPO > itens ) {
		this.itens = itens;
	}

	public ArrayList< SupervisorPO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< SupervisorPO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public void prepararNovo() {
		endereco = new EnderecoPO();
		funcionario = new FuncionarioPO();
		funcionario.setEndereco( endereco );
		funcionario.setTelefones( telefones );
		supervisor = new SupervisorPO();
		supervisor.setFuncionario( funcionario );
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
		List< TelefonePO > pesquisarTelefone = supervisor.getFuncionario().getTelefones();
		TelefonePO telefoneExclusao = new TelefonePO();
		for ( TelefonePO telefonePO : pesquisarTelefone ) {
			if ( telefone.getId() == telefonePO.getId() ) {
				telefoneExclusao = telefonePO;
			}
		}

		telefones.remove( telefoneExclusao );
		supervisor.getFuncionario().setTelefones( telefones );
		SupervisorFacade.getInstance().alterar( supervisor );
		JSFUtil.adicionarMensagemSucesso( "Telefone excluído com sucesso." );
		prepararPesquisa();
	}

	public void gravarTelefones() {
		carregarTelefones(); // Se não tiver essa linha dá erro ao apertar o botão com os campos do fone preenchidos
		supervisor.getFuncionario().setTelefones( telefones );
		SupervisorFacade.getInstance().alterar( supervisor );
		JSFUtil.adicionarMensagemSucesso( "Telefone(s) salvo(s) com sucesso." );
		prepararPesquisa();
	}

	public void carregarTelefones() {
		telefones = supervisor.getFuncionario().getTelefones();
	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		SupervisorPO po = new SupervisorPO();

		itens = (ArrayList< SupervisorPO >) SupervisorFacade.getInstance().filtrar( po );

	}

	public void novo() {

		try {
			SupervisorFacade.getInstance().salvar( supervisor );

			JSFUtil.adicionarMensagemSucesso( "Supervisor salvo com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

	public void excluir() {

		try {
			SupervisorFacade.getInstance().excluir( supervisor );

			JSFUtil.adicionarMensagemSucesso( "Supervisor excluído com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}

	}

	public void editar() {

		try {
			SupervisorFacade.getInstance().alterar( supervisor );

			JSFUtil.adicionarMensagemSucesso( "Supervisor editado com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}
}
