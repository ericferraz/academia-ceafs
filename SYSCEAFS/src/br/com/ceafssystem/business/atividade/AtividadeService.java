package br.com.ceafssystem.business.atividade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.atividade.AtividadeDAO;
import br.com.ceafssystem.domain.atividade.AtividadePO;

@Service
public class AtividadeService{

	@Autowired
	private AtividadeDAO dao;

	public void salvar( AtividadePO po ) {
		this.dao.inserir( po );
	}

	public void alterar( AtividadePO po ) {
		this.dao.alterar( po );
	}

	public List< AtividadePO > filtrar( AtividadePO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( AtividadePO po ) {
		this.dao.excluir( po );
	}

}
