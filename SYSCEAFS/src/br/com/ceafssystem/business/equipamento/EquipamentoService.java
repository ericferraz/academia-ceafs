package br.com.ceafssystem.business.equipamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.equipamento.EquipamentoDAO;
import br.com.ceafssystem.domain.equipamento.EquipamentoPO;

@Service
public class EquipamentoService{

	@Autowired
	private EquipamentoDAO dao;

	public void salvar( EquipamentoPO po ) {
		this.dao.inserir( po );
	}

	public void alterar( EquipamentoPO po ) {
		this.dao.alterar( po );
	}

	public List< EquipamentoPO > filtrar( EquipamentoPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( EquipamentoPO po ) {
		this.dao.excluir( po );
	}

}
