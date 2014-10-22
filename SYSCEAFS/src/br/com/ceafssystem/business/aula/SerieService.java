package br.com.ceafssystem.business.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.aula.SerieDAO;
import br.com.ceafssystem.domain.aula.SeriePO;

@Service
public class SerieService{

	@Autowired
	private SerieDAO dao;

	public void salvar( SeriePO po ) {
		this.dao.inserir( po );
	}

	public void alterar( SeriePO po ) {
		this.dao.alterar( po );
	}

	public List< SeriePO > filtrar( SeriePO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( SeriePO po ) {
		this.dao.excluir( po );
	}

}
