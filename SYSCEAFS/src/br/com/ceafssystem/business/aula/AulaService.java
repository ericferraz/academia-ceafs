package br.com.ceafssystem.business.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.aula.AulaDAO;
import br.com.ceafssystem.domain.aula.AulaPO;

@Service
public class AulaService{

	@Autowired
	private AulaDAO dao;

	public void salvar( AulaPO po ) {
		this.dao.inserir( po );
	}

	public void alterar( AulaPO po ) {
		this.dao.alterar( po );
	}

	public List< AulaPO > filtrar( AulaPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( AulaPO po ) {
		this.dao.excluir( po );
	}

}
