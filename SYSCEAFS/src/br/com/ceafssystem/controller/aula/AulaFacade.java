package br.com.ceafssystem.controller.aula;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.aula.AulaService;
import br.com.ceafssystem.domain.aula.AulaPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class AulaFacade{

	private static AulaService service;

	static {
		service = new AnnotationConfigApplicationContext( AulaFacade.class ).getBean( AulaService.class );
	}

	private static AulaFacade instance;

	public static AulaFacade getInstance() {
		if ( instance == null ) {
			instance = new AulaFacade();
		}
		return instance;
	}

	public void salvar( AulaPO po ) {
		service.salvar( po );
	}

	public void alterar( AulaPO po ) {
		service.alterar( po );
	}

	public List< AulaPO > filtrar( AulaPO po ) {
		return service.filtrar( po );
	}

	public void excluir( AulaPO po ) {
		service.excluir( po );
	}

}
