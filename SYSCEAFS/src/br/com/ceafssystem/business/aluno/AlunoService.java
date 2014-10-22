package br.com.ceafssystem.business.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceafssystem.dao.aluno.AlunoDAO;
import br.com.ceafssystem.domain.pessoa.AlunoPO;

@Service
public class AlunoService{

	@Autowired
	private AlunoDAO dao;

	public void salvar( AlunoPO po ) {
		this.dao.inserir( po );
	}

	public void alterar( AlunoPO po ) {
		this.dao.alterar( po );
	}

	public List< AlunoPO > filtrar( AlunoPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( AlunoPO po ) {
		this.dao.excluir( po );
	}

}
