package br.com.ceafssystem.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import util.JSFUtil;
import br.com.ceafssystem.controller.atividade.AtividadeFacade;
import br.com.ceafssystem.controller.aula.AulaFacade;
import br.com.ceafssystem.controller.aula.SerieFacade;
import br.com.ceafssystem.controller.instrutor.InstrutorFacade;
import br.com.ceafssystem.domain.atividade.AtividadeExercicioPO;
import br.com.ceafssystem.domain.atividade.AtividadePO;
import br.com.ceafssystem.domain.aula.AulaExercicioPO;
import br.com.ceafssystem.domain.aula.AulaPO;
import br.com.ceafssystem.domain.aula.SeriePO;
import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.FuncionarioPO;
import br.com.ceafssystem.domain.pessoa.InstrutorPO;
import br.com.ceafssystem.domain.pessoa.PessoaPO;
import br.com.ceafssystem.queries_jdbc.AulaJDBC;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 20/05/2014 04:18:49
 * @version 1.0
 */
@ManagedBean( name = "MBAula" )
@ViewScoped
public class AulaBean{
	private AulaPO aula;
	private AulaPO aulaSelecionada;
	private InstrutorPO instrutor;
	private FuncionarioPO funcionario;
	private ArrayList< InstrutorPO > comboInstrutores;
	private AlunoPO aluno;
	private PessoaPO pessoa;
	private AtividadePO atividade;
	private ArrayList< AtividadePO > comboAtividades;
	private AtividadeExercicioPO exercicioAtividade = new AtividadeExercicioPO();
	private List< AtividadeExercicioPO > comboExerciciosAtividade = new ArrayList< AtividadeExercicioPO >();
	private ArrayList< AulaPO > itens;
	private ArrayList< AulaPO > itensFiltrados;
	private AulaExercicioPO exercicioAula = new AulaExercicioPO();
	private List< AulaExercicioPO > aulaExercicios = new ArrayList< AulaExercicioPO >();

	private SeriePO serie = new SeriePO();
	private List< SeriePO > series = new ArrayList< SeriePO >();

	private boolean skip;

	private static Logger logger = Logger.getLogger( AulaBean.class.getName() );

	public AulaPO getAula() {
		return aula;
	}

	public void setAula( AulaPO aula ) {
		// Preciso colocar essa linha pois do contrário os exercicios não aparecem ao fazer uma edição
		this.aulaExercicios = new ArrayList< AulaExercicioPO >();
		this.aula = aula;
	}

	public AulaPO getAulaSelecionada() {
		return aulaSelecionada;
	}

	public void setAulaSelecionada( AulaPO aulaSelecionada ) {
		this.aulaSelecionada = aulaSelecionada;
	}

	public InstrutorPO getInstrutor() {
		return instrutor;
	}

	public void setInstrutor( InstrutorPO instrutor ) {
		this.instrutor = instrutor;
	}

	public FuncionarioPO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario( FuncionarioPO funcionario ) {
		this.funcionario = funcionario;
	}

	public ArrayList< InstrutorPO > getComboInstrutores() {
		return comboInstrutores;
	}

	public void setComboInstrutores( ArrayList< InstrutorPO > comboInstrutores ) {
		this.comboInstrutores = comboInstrutores;
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

	public AtividadePO getAtividade() {
		return atividade;
	}

	public void setAtividade( AtividadePO atividade ) {
		this.atividade = atividade;
		popularComboExerciciosAtividade();//add
	}

	public ArrayList< AtividadePO > getComboAtividades() {
		return comboAtividades;
	}

	public void setComboAtividades( ArrayList< AtividadePO > comboAtividades ) {
		this.comboAtividades = comboAtividades;
	}

	public AtividadeExercicioPO getExercicioAtividade() {
		return exercicioAtividade;
	}

	public void setExercicioAtividade( AtividadeExercicioPO exercicioAtividade ) {
		this.exercicioAtividade = exercicioAtividade;
	}

	public List< AtividadeExercicioPO > getComboExerciciosAtividade() {
		return comboExerciciosAtividade;
	}

	public void setComboExerciciosAtividade( List< AtividadeExercicioPO > comboExerciciosAtividade ) {
		this.comboExerciciosAtividade = comboExerciciosAtividade;
	}

	public ArrayList< AulaPO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< AulaPO > itens ) {
		this.itens = itens;
	}

	public ArrayList< AulaPO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< AulaPO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public AulaExercicioPO getExercicioAula() {
		return exercicioAula;
	}

	public void setExercicioAula( AulaExercicioPO exercicioAula ) {
		this.exercicioAula = exercicioAula;
	}

	public List< AulaExercicioPO > getAulaExercicios() {
		return aulaExercicios;
	}

	public void setAulaExercicios( List< AulaExercicioPO > aulaExercicios ) {
		this.aulaExercicios = aulaExercicios;
	}

	public SeriePO getSerie() {
		return serie;
	}

	public void setSerie( SeriePO serie ) {
		this.serie = serie;
	}

	public List< SeriePO > getSeries() {
		return series;
	}

	public void setSeries( List< SeriePO > series ) {
		this.series = series;
	}

	public void prepararNovo() {
		funcionario = new FuncionarioPO();
		instrutor = new InstrutorPO();
		instrutor.setFuncionario( funcionario );
		pessoa = new PessoaPO();
		aluno = new AlunoPO();
		aluno.setPessoa( pessoa );
		atividade = new AtividadePO();
		atividade.setAluno( aluno );
		aula = new AulaPO();
		aula.setAtividade( atividade );
		aula.setInstrutor( instrutor );
		aulaExercicios = new ArrayList< AulaExercicioPO >();
		aula.setAulaExercicios( aulaExercicios );
		popularComboInstrutores();
		popularComboAtividades();
		//popularComboExerciciosAtividade();
		series = new ArrayList< SeriePO >();
	}

	public void popularComboInstrutores() {

		InstrutorPO po = new InstrutorPO();

		comboInstrutores = (ArrayList< InstrutorPO >) InstrutorFacade.getInstance().filtrar( po );

	}

	public void popularComboAtividades() {

		AtividadePO po = new AtividadePO();

		comboAtividades = (ArrayList< AtividadePO >) AtividadeFacade.getInstance().filtrar( po );

	}

	public void popularComboExerciciosAtividade() {

		//aula.setAtividade( atividade );

		comboExerciciosAtividade = atividade.getAtividadeExercicios();

	}

	public void adicionarExercicioAula() {
		adicionarSerie();
		aulaExercicios.add( exercicioAula );
		exercicioAula = new AulaExercicioPO();
	}

	public void removerExercicio( AulaExercicioPO exercicioAula ) {
		// Rotina para remover todas as séries desse exercício a ser removido
		aulaExercicios.remove( exercicioAula );

	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		/*AulaPO po = new AulaPO();

		itens = (ArrayList< AulaPO >) AulaFacade.getInstance().filtrar( po );*/

		AulaJDBC dao = new AulaJDBC();

		try {
			itens = dao.listar();
		} catch ( SQLException e ) {
			JSFUtil.adicionarMensagemErro( e.getMessage() );
			e.printStackTrace();
		}

	}

	public void novo() {

		try {
			aula.setAtividade( atividade );

			AulaFacade.getInstance().salvar( aula );

			JSFUtil.adicionarMensagemSucesso( "Aula salva com sucesso." );

			for ( SeriePO po : series ) {

				SerieFacade.getInstance().salvar( po );

			}

			JSFUtil.adicionarMensagemSucesso( "Séries salvas com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
		// tenho que colocar esses métodos aqui pois meu novo está na metadata
		// e estava ficando o objeto preenchido depois que salvava
		// se usar aulaExercicios.clear(); tem o problema do último
		// que inseri ficar sem exercícios.
		prepararNovo();
		series = new ArrayList< SeriePO >();
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

	public void adicionarSerie() {
		serie.setAulaExercicio( exercicioAula );
		serie.setAlunoSerie( atividade.getAluno().getId() );
		serie.setDataAula( aula.getDataAula() );
		series.add( serie );
		serie = new SeriePO();
	}

	public void removerSerie( SeriePO serie ) {
		series.remove( serie );
	}

}
