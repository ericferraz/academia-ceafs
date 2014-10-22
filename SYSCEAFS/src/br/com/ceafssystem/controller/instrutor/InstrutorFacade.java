package br.com.ceafssystem.controller.instrutor;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.instrutor.InstrutorService;
import br.com.ceafssystem.domain.pessoa.InstrutorPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class InstrutorFacade{

	private static InstrutorService service;

	static {
		service = new AnnotationConfigApplicationContext( InstrutorFacade.class ).getBean( InstrutorService.class );
	}

	private static InstrutorFacade instance;

	public static InstrutorFacade getInstance() {
		if ( instance == null ) {
			instance = new InstrutorFacade();
		}
		return instance;
	}

	public void salvar( InstrutorPO po ) {
		service.salvar( po );
	}

	public void alterar( InstrutorPO po ) {
		service.alterar( po );
	}

	public List< InstrutorPO > filtrar( InstrutorPO po ) {
		return service.filtrar( po );
	}

	public void excluir( InstrutorPO po ) {
		service.excluir( po );
	}

}
