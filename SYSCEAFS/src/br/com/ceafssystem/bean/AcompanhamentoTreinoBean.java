package br.com.ceafssystem.bean;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;

import util.JSFUtil;
import br.com.ceafssystem.controller.aluno.AlunoFacade;
import br.com.ceafssystem.domain.aula.SeriePO;
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
@ManagedBean( name = "MBAcompanhamentoTreinos" )
@ViewScoped
public class AcompanhamentoTreinoBean{

	private SeriePO serie;
	private AlunoPO aluno;
	private PessoaPO pessoa;
	private ArrayList< AlunoPO > comboAlunos;
	private ArrayList< SeriePO > itens;
	private ArrayList< SeriePO > itensFiltrados;

	private String[ ] selectedConsoles;

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

	public String[ ] getSelectedConsoles() {
		return selectedConsoles;
	}

	public void setSelectedConsoles( String[ ] selectedConsoles ) {
		this.selectedConsoles = selectedConsoles;
	}

	@PostConstruct
	public void popularComboAlunos() {

		AlunoPO po = new AlunoPO();

		comboAlunos = (ArrayList< AlunoPO >) AlunoFacade.getInstance().filtrar( po );

	}

	public void selecionarSeriesAluno() {
		Long id = aluno.getId();

		SerieJDBC dao = new SerieJDBC();

		try {
			itens = dao.listarPorDataAtual( id );
		} catch ( SQLException e ) {
			JSFUtil.adicionarMensagemErro( e.getMessage() );
			e.printStackTrace();
		}
	}

	public void mensagem() {
		JSFUtil.adicionarMensagemSucesso( "Série completa!" );
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
