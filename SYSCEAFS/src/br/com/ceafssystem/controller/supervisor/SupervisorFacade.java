package br.com.ceafssystem.controller.supervisor;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.supervisor.SupervisorService;
import br.com.ceafssystem.domain.pessoa.SupervisorPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class SupervisorFacade{

	private static SupervisorService service;

	static {
		service = new AnnotationConfigApplicationContext( SupervisorFacade.class ).getBean( SupervisorService.class );
	}

	private static SupervisorFacade instance;

	public static SupervisorFacade getInstance() {
		if ( instance == null ) {
			instance = new SupervisorFacade();
		}
		return instance;
	}

	public void salvar( SupervisorPO po ) {
		service.salvar( po );
	}

	public void alterar( SupervisorPO po ) {
		service.alterar( po );
	}

	public List< SupervisorPO > filtrar( SupervisorPO po ) {
		return service.filtrar( po );
	}

	public void excluir( SupervisorPO po ) {
		service.excluir( po );
	}

}
