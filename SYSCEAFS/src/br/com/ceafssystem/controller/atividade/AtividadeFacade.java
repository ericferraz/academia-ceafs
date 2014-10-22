package br.com.ceafssystem.controller.atividade;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.atividade.AtividadeService;
import br.com.ceafssystem.domain.atividade.AtividadePO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class AtividadeFacade{

	private static AtividadeService service;

	static {
		service = new AnnotationConfigApplicationContext( AtividadeFacade.class ).getBean( AtividadeService.class );
	}

	private static AtividadeFacade instance;

	public static AtividadeFacade getInstance() {
		if ( instance == null ) {
			instance = new AtividadeFacade();
		}
		return instance;
	}

	public void salvar( AtividadePO po ) {
		service.salvar( po );
	}

	public void alterar( AtividadePO po ) {
		service.alterar( po );
	}

	public List< AtividadePO > filtrar( AtividadePO po ) {
		return service.filtrar( po );
	}

	public void excluir( AtividadePO po ) {
		service.excluir( po );
	}

}
