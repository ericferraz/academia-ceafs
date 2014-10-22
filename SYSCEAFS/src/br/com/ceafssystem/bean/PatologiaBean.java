package br.com.ceafssystem.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import br.com.ceafssystem.controller.patologia.PatologiaFacade;
import br.com.ceafssystem.domain.patologia.PatologiaPO;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 31/03/2014 00:48:12
 * @version 1.0
 */
@ManagedBean( name = "MBPatologia" )
@ViewScoped
public class PatologiaBean{
	private PatologiaPO patologia;
	private ArrayList< PatologiaPO > itens;
	private ArrayList< PatologiaPO > itensFiltrados;

	public PatologiaPO getPatologia() {
		return patologia;
	}

	public void setPatologia( PatologiaPO patologia ) {
		this.patologia = patologia;
	}

	public ArrayList< PatologiaPO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< PatologiaPO > itens ) {
		this.itens = itens;
	}

	public ArrayList< PatologiaPO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< PatologiaPO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public void prepararNovo() {
		patologia = new PatologiaPO();
	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		PatologiaPO po = new PatologiaPO();

		
		itens = (ArrayList<PatologiaPO>) PatologiaFacade.getInstance().filtrar(po);

	}

	public void novo() {

		try {
			PatologiaFacade.getInstance().salvar(patologia);

			JSFUtil.adicionarMensagemSucesso( "Patologia salva com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

	public void excluir() {

		try {
			PatologiaFacade.getInstance().excluir(patologia);

			JSFUtil.adicionarMensagemSucesso( "Patologia excluída com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}

	}

	public void editar() {

		try {
			PatologiaFacade.getInstance().alterar(patologia);

			JSFUtil.adicionarMensagemSucesso( "Patologia editada com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}
}
