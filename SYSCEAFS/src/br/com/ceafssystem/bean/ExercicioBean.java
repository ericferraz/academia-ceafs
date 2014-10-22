package br.com.ceafssystem.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import br.com.ceafssystem.controller.equipamento.EquipamentoFacade;
import br.com.ceafssystem.controller.exercicio.ExercicioFacade;
import br.com.ceafssystem.domain.equipamento.EquipamentoPO;
import br.com.ceafssystem.domain.exercicio.ExercicioPO;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 31/03/2014 00:48:12
 * @version 1.0
 */
@ManagedBean( name = "MBExercicio" )
@ViewScoped
public class ExercicioBean{
	private ExercicioPO exercicio;
	private EquipamentoPO equipamento;
	private ArrayList< EquipamentoPO > comboEquipamentos;
	private ArrayList< ExercicioPO > itens;
	private ArrayList< ExercicioPO > itensFiltrados;

	public ExercicioPO getExercicio() {
		return exercicio;
	}

	public void setExercicio( ExercicioPO exercicio ) {
		this.exercicio = exercicio;
	}

	public EquipamentoPO getEquipamento() {
		return equipamento;
	}

	public void setEquipamento( EquipamentoPO equipamento ) {
		this.equipamento = equipamento;
	}

	public ArrayList< EquipamentoPO > getComboEquipamentos() {
		return comboEquipamentos;
	}

	public void setComboEquipamentos( ArrayList< EquipamentoPO > comboEquipamentos ) {
		this.comboEquipamentos = comboEquipamentos;
	}

	public ArrayList< ExercicioPO > getItens() {
		return itens;
	}

	public void setItens( ArrayList< ExercicioPO > itens ) {
		this.itens = itens;
	}

	public ArrayList< ExercicioPO > getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados( ArrayList< ExercicioPO > itensFiltrados ) {
		this.itensFiltrados = itensFiltrados;
	}

	public void prepararNovo() {
		equipamento = new EquipamentoPO();
		exercicio = new ExercicioPO();
		exercicio.setEquipamento( equipamento );
		popularCombo();
	}

	public void popularCombo() {

		EquipamentoPO po = new EquipamentoPO();

		comboEquipamentos = (ArrayList< EquipamentoPO >) EquipamentoFacade.getInstance().filtrar( po );

	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		ExercicioPO po = new ExercicioPO();

		itens = (ArrayList< ExercicioPO >) ExercicioFacade.getInstance().filtrar( po );

	}

	public void novo() {

		try {
			/*if ( exercicio.getEquipamento() == null ) {
				exercicio.setEquipamento( null );
			}*/

			ExercicioFacade.getInstance().salvar( exercicio );

			JSFUtil.adicionarMensagemSucesso( "Exercício salvo com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

	public void excluir() {

		try {
			ExercicioFacade.getInstance().excluir( exercicio );

			JSFUtil.adicionarMensagemSucesso( "Exercício excluído com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}

	}

	public void editar() {

		try {
			ExercicioFacade.getInstance().alterar( exercicio );

			JSFUtil.adicionarMensagemSucesso( "Exercício editado com sucesso." );

			prepararPesquisa();

		} catch ( Throwable t ) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro( t.getMessage() );
		}
	}

}
