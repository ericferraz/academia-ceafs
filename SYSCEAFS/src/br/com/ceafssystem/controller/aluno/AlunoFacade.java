package br.com.ceafssystem.controller.aluno;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.aluno.AlunoService;
import br.com.ceafssystem.domain.pessoa.AlunoPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class AlunoFacade{

	private static AlunoService service;

	static {
		service = new AnnotationConfigApplicationContext( AlunoFacade.class ).getBean( AlunoService.class );
	}

	private static AlunoFacade instance;

	public static AlunoFacade getInstance() {
		if ( instance == null ) {
			instance = new AlunoFacade();
		}
		return instance;
	}

	public void salvar( AlunoPO po ) {
		service.salvar( po );
	}

	public void alterar( AlunoPO po ) {
		service.alterar( po );
	}

	public List< AlunoPO > filtrar( AlunoPO po ) {
		return service.filtrar( po );
	}

	public void excluir( AlunoPO po ) {
		service.excluir( po );
	}

}
