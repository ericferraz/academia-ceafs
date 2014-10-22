package br.com.ceafssystem.business.exercicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.exercicio.ExercicioDAO;
import br.com.ceafssystem.domain.exercicio.ExercicioPO;

@Service
public class ExercicioService{

	@Autowired
	private ExercicioDAO dao;

	public void salvar( ExercicioPO po ) {
		this.dao.inserir( po );
	}

	public void alterar( ExercicioPO po ) {
		this.dao.alterar( po );
	}

	public List< ExercicioPO > filtrar( ExercicioPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( ExercicioPO po ) {
		this.dao.excluir( po );
	}

}
