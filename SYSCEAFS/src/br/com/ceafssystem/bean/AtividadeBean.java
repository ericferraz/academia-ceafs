package br.com.ceafssystem.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.FlowEvent;

import util.JSFUtil;
import br.com.ceafssystem.controller.aluno.AlunoFacade;
import br.com.ceafssystem.controller.atividade.AtividadeFacade;
import br.com.ceafssystem.controller.exercicio.ExercicioFacade;
import br.com.ceafssystem.controller.supervisor.SupervisorFacade;
import br.com.ceafssystem.domain.atividade.AtividadeExercicioPO;
import br.com.ceafssystem.domain.atividade.AtividadePO;
import br.com.ceafssystem.domain.exercicio.ExercicioPO;
import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.FuncionarioPO;
import br.com.ceafssystem.domain.pessoa.PessoaPO;
import br.com.ceafssystem.domain.pessoa.SupervisorPO;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 20/05/2014 04:18:49
 * @version 1.0
 */
@ManagedBean( name = "MBAtividade" )
@ViewScoped
public class AtividadeBean{
	private AtividadePO atividade;
	private AtividadePO atividadeSelecionada;
	private SupervisorPO supervisor;
	private FuncionarioPO funcionario;
	private ArrayList< SupervisorPO > comboSupervisores;
	private AlunoPO aluno;
	private PessoaPO pessoa;
	private ArrayList< AlunoPO > comboAlunos;
	private ExercicioPO exercicio = new ExercicioPO();
	private List< ExercicioPO > comboExercicios = new ArrayList< ExercicioPO >();
	private ArrayList< AtividadePO > itens;
	private ArrayList< AtividadePO > itensFiltrados;
	private AtividadeExercicioPO exercicioAtividade = new AtividadeExercicioPO();
	private List< AtividadeExercicioPO > atividadeExercicios = new ArrayList< AtividadeExercicioPO >();

	private boolean skip;

	private static Logger logger = Logger.getLogger( AtividadeBean.class.getName() );

	public AtividadePO getAtividade() {
		return atividade;
	}

	public void setAtividade( AtividadePO atividade ) {
		// Preciso colocar essa linha pois do contrário os exercicios não aparecem ao fazer uma edição
		this.atividadeExercicios = new ArrayList< AtividadeExercicioPO >();
		this.atividade = atividade;
	}

	public AtividadePO getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	public void setAtividadeSelecionada( AtividadePO atividadeSelecionada ) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

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

	public ArrayList< SupervisorPO > getComboSupervisores() {
		return comboSupervisores;
	}

	public void setComboSupervisores( ArrayList< SupervisorPO > comboSupervisores ) {
		this.comboSupervisores = comboSupervisores;
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

	public ExercicioPO getExercicio() {
		return exercicio;
	}

	public void setExercicio( ExercicioPO exercicio ) {
		this.exercicio = exercicio;
	}

	public List< ExercicioPO > getComboExercicios() {
		return comboExercicios;
	}

	public void setComboExercicios( List< ExercicioPO > comboExercicios ) {
		this.comboExercicios = comboExercicios;
	}

	public ArrayList< AtividadePO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< AtividadePO > itens ) {
		this.itens = itens;
	}

	public ArrayList< AtividadePO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< AtividadePO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public AtividadeExercicioPO getExercicioAtividade() {
		return exercicioAtividade;
	}

	public void setExercicioAtividade( AtividadeExercicioPO exercicioAtividade ) {
		this.exercicioAtividade = exercicioAtividade;
	}

	public List< AtividadeExercicioPO > getAtividadeExercicios() {
		return atividadeExercicios;
	}

	public void setAtividadeExercicios( List< AtividadeExercicioPO > atividadeExercicios ) {
		this.atividadeExercicios = atividadeExercicios;
	}

	public void prepararNovo() {
		funcionario = new FuncionarioPO();
		supervisor = new SupervisorPO();
		supervisor.setFuncionario( funcionario );
		pessoa = new PessoaPO();
		aluno = new AlunoPO();
		aluno.setPessoa( pessoa );
		atividade = new AtividadePO();
		atividade.setSupervisor( supervisor );
		atividade.setAluno( aluno );
		atividadeExercicios = new ArrayList< AtividadeExercicioPO >();
		atividade.setAtividadeExercicios( atividadeExercicios );
		popularComboSupervisores();
		popularComboAlunos();
		popularComboExercicios();
	}

	public void popularComboSupervisores() {

		SupervisorPO po = new SupervisorPO();

		comboSupervisores = (ArrayList< SupervisorPO >) SupervisorFacade.getInstance().filtrar( po );

	}

	public void popularComboAlunos() {

		AlunoPO po = new AlunoPO();

		comboAlunos = (ArrayList< AlunoPO >) AlunoFacade.getInstance().filtrar( po );

	}

	public void popularComboExercicios() {

		ExercicioPO po = new ExercicioPO();

		comboExercicios = (ArrayList< ExercicioPO >) ExercicioFacade.getInstance().filtrar( po );

	}

	public void adicionarExercicio() {
		atividadeExercicios.add( exercicioAtividade );
		exercicioAtividade = new AtividadeExercicioPO();
	}

	public void removerExercicio( AtividadeExercicioPO exercicioAtv ) {
		atividadeExercicios.remove( exercicioAtv );
	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		AtividadePO po = new AtividadePO();

		itens = (ArrayList< AtividadePO >) AtividadeFacade.getInstance().filtrar( po );

	}

	public void novo() {

		try {

			AtividadeFacade.getInstance().salvar( atividade );

			JSFUtil.adicionarMensagemSucesso( "Atividade salva com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
		// tenho que colocar esses métodos aqui pois meu novo está na metadata
		// e estava ficando o objeto preenchido depois que salvava
		// se usar atividadeExercicios.clear(); tem o problema do último
		// que inseri ficar sem exercícios.
		prepararNovo();
	}

	public void excluir() {

		try {
			AtividadeFacade.getInstance().excluir( atividadeSelecionada );

			JSFUtil.adicionarMensagemSucesso( "Atividade excluída com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}

	}

	public void editar() {

		try {
			AtividadeFacade.getInstance().alterar( atividadeSelecionada );

			JSFUtil.adicionarMensagemSucesso( "Atividade editada com sucesso." );

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

	public void postProcessXLS( Object document ) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt( 0 );
		HSSFRow header = sheet.getRow( 0 );

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor( HSSFColor.AQUA.index );
		cellStyle.setFillPattern( HSSFCellStyle.SOLID_FOREGROUND );

		for ( int i = 0; i < header.getPhysicalNumberOfCells(); i++ ) {
			HSSFCell cell = header.getCell( i );

			cell.setCellStyle( cellStyle );
		}
	}

	public void preProcessPDF( Object document ) throws IOException, BadElementException, DocumentException {
		Document pdf = (Document) document;
		pdf.open();
		pdf.setPageSize( PageSize.A4 );

		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath( "" ) + File.separator + "resources" + File.separator + "images" + File.separator + "logoCabecalhoReduzido.png";

		pdf.add( Image.getInstance( logo ) );
	}

	public void postProcessPDF( Object document ) throws IOException, BadElementException, DocumentException {
		Document pdf = (Document) document;

		HeaderFooter footer = new HeaderFooter( new Phrase( "CEAFS - Centro Especializado em Atividade Fisica Supervisionada - Ourinhos (SP)" ), new Phrase( "." ) );

		pdf.add( footer );
	}

}
