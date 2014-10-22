package br.com.ceafssystem.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import util.JSFUtil;
import br.com.ceafssystem.controller.acompanhamento.AcompanhamentoFacade;
import br.com.ceafssystem.controller.aluno.AlunoFacade;
import br.com.ceafssystem.controller.patologia.PatologiaFacade;
import br.com.ceafssystem.domain.patologia.AcompanhamentoPO;
import br.com.ceafssystem.domain.patologia.AcompanhamentoPatologiaPO;
import br.com.ceafssystem.domain.patologia.PatologiaPO;
import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.PessoaPO;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 * 
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 31/03/2014 00:48:12
 * @version 1.0
 */
@ManagedBean( name = "MBAcompanhamento" )
@ViewScoped
public class AcompanhamentoBean{
	private AcompanhamentoPO acompanhamento;
	private AcompanhamentoPO acompanhamentoSelecionado;
	private AlunoPO aluno;
	private PessoaPO pessoa;
	private ArrayList< AlunoPO > comboAlunos;
	private PatologiaPO patologia = new PatologiaPO();
	private List< PatologiaPO > comboPatologias = new ArrayList< PatologiaPO >();
	private ArrayList< AcompanhamentoPO > itens;
	private ArrayList< AcompanhamentoPO > itensFiltrados;
	private AcompanhamentoPatologiaPO patologiaAcompanhada = new AcompanhamentoPatologiaPO();
	private List< AcompanhamentoPatologiaPO > acompanhamentoPatologias = new ArrayList< AcompanhamentoPatologiaPO >();

	private boolean skip;

	private static Logger logger = Logger.getLogger( AcompanhamentoBean.class.getName() );

	public AcompanhamentoPO getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento( AcompanhamentoPO acompanhamento ) {
		// Preciso colocar essa linha pois do contrário as patologias não aparecem ao fazer uma edição
		this.acompanhamentoPatologias = new ArrayList< AcompanhamentoPatologiaPO >();
		this.acompanhamento = acompanhamento;
	}

	public AcompanhamentoPO getAcompanhamentoSelecionado() {
		return acompanhamentoSelecionado;
	}

	public void setAcompanhamentoSelecionado( AcompanhamentoPO acompanhamentoSelecionado ) {
		this.acompanhamentoSelecionado = acompanhamentoSelecionado;
	}

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

	public ArrayList< AlunoPO > getComboAlunos() {
		return comboAlunos;
	}

	public void setComboAlunos( ArrayList< AlunoPO > comboAlunos ) {
		this.comboAlunos = comboAlunos;
	}

	public PatologiaPO getPatologia() {
		return patologia;
	}

	public void setPatologia( PatologiaPO patologia ) {
		this.patologia = patologia;
	}

	public List< PatologiaPO > getComboPatologias() {
		return comboPatologias;
	}

	public void setComboPatologias( List< PatologiaPO > comboPatologias ) {
		this.comboPatologias = comboPatologias;
	}

	public ArrayList< AcompanhamentoPO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< AcompanhamentoPO > itens ) {
		this.itens = itens;
	}

	public ArrayList< AcompanhamentoPO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< AcompanhamentoPO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public AcompanhamentoPatologiaPO getPatologiaAcompanhada() {
		return patologiaAcompanhada;
	}

	public void setPatologiaAcompanhada( AcompanhamentoPatologiaPO patologiaAcompanhada ) {
		this.patologiaAcompanhada = patologiaAcompanhada;
	}

	public List< AcompanhamentoPatologiaPO > getAcompanhamentoPatologias() {
		return acompanhamentoPatologias;
	}

	public void setAcompanhamentoPatologias( List< AcompanhamentoPatologiaPO > acompanhamentoPatologias ) {
		this.acompanhamentoPatologias = acompanhamentoPatologias;
	}

	public void prepararNovo() {
		pessoa = new PessoaPO();
		aluno = new AlunoPO();
		aluno.setPessoa( pessoa );
		acompanhamento = new AcompanhamentoPO();
		acompanhamento.setAluno( aluno );
		acompanhamentoPatologias = new ArrayList< AcompanhamentoPatologiaPO >();
		acompanhamento.setAcompanhamentoPatologias( acompanhamentoPatologias );
		popularComboAlunos();
		popularComboPatologias();
	}

	public void popularComboAlunos() {

		AlunoPO po = new AlunoPO();

		comboAlunos = (ArrayList< AlunoPO >) AlunoFacade.getInstance().filtrar( po );

	}

	public void popularComboPatologias() {

		PatologiaPO po = new PatologiaPO();

		comboPatologias = (ArrayList< PatologiaPO >) PatologiaFacade.getInstance().filtrar( po );

	}

	public void adicionarPatologia() {
		acompanhamentoPatologias.add( patologiaAcompanhada );
		patologiaAcompanhada = new AcompanhamentoPatologiaPO();
	}

	public void removerPatologia( AcompanhamentoPatologiaPO patologiaAcp ) {
		acompanhamentoPatologias.remove( patologiaAcp );
	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		AcompanhamentoPO po = new AcompanhamentoPO();

		itens = (ArrayList< AcompanhamentoPO >) AcompanhamentoFacade.getInstance().filtrar( po );

	}

	public void novo() {

		try {

			AcompanhamentoFacade.getInstance().salvar( acompanhamento );

			JSFUtil.adicionarMensagemSucesso( "Acompanhamento Médico salvo com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
		// tenho que colocar esses métodos aqui pois meu novo está na metadata
		// e estava ficando o objeto preenchido depois que salvava
		// se usar acompanhamentoPatologias.clear(); tem o problema do último
		// que inseri ficar sem patologias.
		prepararNovo();
	}

	public void excluir() {

		try {
			AcompanhamentoFacade.getInstance().excluir( acompanhamentoSelecionado );

			JSFUtil.adicionarMensagemSucesso( "Acompanhamento Médico excluído com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}

	}

	public void editar() {

		try {
			AcompanhamentoFacade.getInstance().alterar( acompanhamentoSelecionado );

			JSFUtil.adicionarMensagemSucesso( "Acompanhamento Médico editado com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip( boolean skip ) {
		this.skip = skip;
	}

	public String onFlowProcess( FlowEvent event ) {
		logger.info( "Current wizard step:" + event.getOldStep() );
		logger.info( "Next step:" + event.getNewStep() );

		if ( skip ) {
			skip = false; //reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

}
