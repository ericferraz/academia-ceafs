package br.com.ceafssystem.business.patologia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.patologia.PatologiaDAO;
import br.com.ceafssystem.domain.patologia.PatologiaPO;

@Service
public class PatologiaService{

	@Autowired
	private PatologiaDAO dao;

	public void salvar( PatologiaPO po ) {
		this.dao.inserir( po );
	}

	public void alterar( PatologiaPO po ) {
		this.dao.alterar( po );
	}

	public List< PatologiaPO > filtrar( PatologiaPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( PatologiaPO po ) {
		this.dao.excluir( po );
	}

}
