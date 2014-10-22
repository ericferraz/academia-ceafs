package br.com.ceafssystem.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import util.JSFUtil;
import br.com.ceafssystem.controller.aluno.AlunoFacade;
import br.com.ceafssystem.controller.exercicio.ExercicioFacade;
import br.com.ceafssystem.domain.aula.SeriePO;
import br.com.ceafssystem.domain.exercicio.ExercicioPO;
import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.PessoaPO;
import br.com.ceafssystem.queries_jdbc.SerieJDBC;

/**
 * 
 * Classe que representa
 *
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 03/06/2014 19:56:30
 * @version 1.0
 */
@ManagedBean( name = "MBEvolucaoAluno" )
@SessionScoped
public class EvolucaoAlunoBean{

	private SeriePO serie;
	private AlunoPO aluno;
	private PessoaPO pessoa;
	private ArrayList< AlunoPO > comboAlunos;
	private ArrayList< SeriePO > itens;
	private ArrayList< SeriePO > itensFiltrados;
	
	private ExercicioPO exercicio = new ExercicioPO();
	private List< ExercicioPO > comboExercicios = new ArrayList< ExercicioPO >();

	private CartesianChartModel model;

	public SeriePO getSerie() {
		return serie;
	}

	public void setSerie( SeriePO serie ) {
		this.serie = serie;
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

	public ArrayList< SeriePO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< SeriePO > itens ) {
		this.itens = itens;
	}

	public ArrayList< SeriePO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< SeriePO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void popularCombos() {

		AlunoPO po = new AlunoPO();

		comboAlunos = (ArrayList< AlunoPO >) AlunoFacade.getInstance().filtrar( po );
		
		ExercicioPO poo = new ExercicioPO();

		comboExercicios = (ArrayList< ExercicioPO >) ExercicioFacade.getInstance().filtrar( poo );

		model = new CartesianChartModel();

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

	public void createDateModel() {
		Long id = aluno.getId();
		Long idEx = exercicio.getId();

		SerieJDBC dao = new SerieJDBC();

		try {
			itens = dao.listarTodasSeriesAluno( id, idEx );

			model = new CartesianChartModel();

			ChartSeries cargaDireita = new ChartSeries();

			for ( SeriePO seriePO : itens ) {
				cargaDireita.set( seriePO.getDataAula(), Integer.parseInt( seriePO.getCargaDireita() ) );
				cargaDireita.setLabel( "Carga Direita" );

			}

			model.addSeries( cargaDireita );

			ChartSeries cargaEsquerda = new ChartSeries();

			for ( SeriePO seriePO : itens ) {
				cargaEsquerda.set( seriePO.getDataAula(), Integer.parseInt( seriePO.getCargaEsquerda() ) );
				cargaEsquerda.setLabel( "Carga Esquerda" );

			}

			model.addSeries( cargaEsquerda );

			this.refresh();

		} catch ( SQLException e ) {
			JSFUtil.adicionarMensagemErro( e.getMessage() );
			e.printStackTrace();
		}
	}

	public CartesianChartModel getModel() {
		return model;
	}

	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView( context, context.getViewRoot().getViewId() );
		context.setViewRoot( viewRoot );
		context.renderResponse();
	}

}
