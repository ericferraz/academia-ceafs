package br.com.ceafssystem.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.JSFUtil;
import br.com.ceafssystem.controller.equipamento.EquipamentoFacade;
import br.com.ceafssystem.domain.equipamento.ConfiguracaoPO;
import br.com.ceafssystem.domain.equipamento.EquipamentoPO;

/**
 * 
 * Classe Java responsável pela lógica (comportamento) da minha interface,
 * revestida por um .xhtml
 * 
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 31/03/2014 00:48:12
 * @version 1.0
 */
@ManagedBean(name = "MBEquipamento")
@ViewScoped
public class EquipamentoBean {
	private EquipamentoPO equipamento;
	private ConfiguracaoPO configuracaoEquipamento;
	private ArrayList<EquipamentoPO> itens;
	private ArrayList<EquipamentoPO> itensFiltrados;

	public EquipamentoPO getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(EquipamentoPO equipamento) {
		this.equipamento = equipamento;
	}

	public ConfiguracaoPO getConfiguracaoEquipamento() {
		return configuracaoEquipamento;
	}

	public void setConfiguracaoEquipamento(ConfiguracaoPO configuracaoEquipamento) {
		this.configuracaoEquipamento = configuracaoEquipamento;
	}

	public ArrayList<EquipamentoPO> getItens() {
		return itens;
	}

	public void setItens(ArrayList<EquipamentoPO> itens) {
		this.itens = itens;
	}

	public ArrayList<EquipamentoPO> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<EquipamentoPO> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void prepararNovo() {
		configuracaoEquipamento = new ConfiguracaoPO();
		equipamento = new EquipamentoPO();
		equipamento.setConfiguracao(configuracaoEquipamento);
	}

	// esse método PRECISA ser void (sem retorno) pois possui a Annotation
	// PostConstruct
	@PostConstruct
	public void prepararPesquisa() {

		EquipamentoPO po = new EquipamentoPO();

		itens = (ArrayList<EquipamentoPO>) EquipamentoFacade.getInstance()
				.filtrar(po);

	}

	public void novo() {

		try {
			EquipamentoFacade.getInstance().salvar(equipamento);

			JSFUtil.adicionarMensagemSucesso("Equipamento salvo com sucesso.");

			prepararPesquisa();

		} catch (Throwable t) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro(t.getMessage());
		}
	}

	public void excluir() {

		try {
			EquipamentoFacade.getInstance().excluir(equipamento);

			JSFUtil.adicionarMensagemSucesso("Equipamento excluído com sucesso.");

			prepararPesquisa();

		} catch (Throwable t) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro(t.getMessage());
		}

	}

	public void editar() {

		try {
			EquipamentoFacade.getInstance().alterar(equipamento);

			JSFUtil.adicionarMensagemSucesso("Equipamento editado com sucesso.");

			prepararPesquisa();

		} catch (Throwable t) {
			t.printStackTrace();
			JSFUtil.adicionarMensagemErro(t.getMessage());
		}
	}
}
