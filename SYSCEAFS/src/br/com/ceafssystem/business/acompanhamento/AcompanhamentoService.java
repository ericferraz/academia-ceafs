package br.com.ceafssystem.business.acompanhamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.acompanhamento.AcompanhamentoDAO;
import br.com.ceafssystem.domain.patologia.AcompanhamentoPO;

@Service
public class AcompanhamentoService{

	@Autowired
	private AcompanhamentoDAO dao;

	public void salvar( AcompanhamentoPO po ) {
		
		this.dao.inserir( po );
	}

	public void alterar( AcompanhamentoPO po ) {
		this.dao.alterar( po );
	}

	public List< AcompanhamentoPO > filtrar( AcompanhamentoPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( AcompanhamentoPO po ) {
		this.dao.excluir( po );
	}

}
