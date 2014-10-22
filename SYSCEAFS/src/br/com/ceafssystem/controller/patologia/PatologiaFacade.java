package br.com.ceafssystem.controller.patologia;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.patologia.PatologiaService;
import br.com.ceafssystem.domain.patologia.PatologiaPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class PatologiaFacade{

	private static PatologiaService service;

	static {
		service = new AnnotationConfigApplicationContext( PatologiaFacade.class ).getBean( PatologiaService.class );
	}

	private static PatologiaFacade instance;

	public static PatologiaFacade getInstance() {
		if ( instance == null ) {
			instance = new PatologiaFacade();
		}
		return instance;
	}

	public void salvar( PatologiaPO po ) {
		service.salvar( po );
	}

	public void alterar( PatologiaPO po ) {
		service.alterar( po );
	}

	public List< PatologiaPO > filtrar( PatologiaPO po ) {
		return service.filtrar( po );
	}

	public void excluir( PatologiaPO po ) {
		service.excluir( po );
	}

}
