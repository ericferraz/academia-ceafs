package br.com.ceafssystem.controller.aula;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.aula.SerieService;
import br.com.ceafssystem.domain.aula.SeriePO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class SerieFacade{

	private static SerieService service;

	static {
		service = new AnnotationConfigApplicationContext( SerieFacade.class ).getBean( SerieService.class );
	}

	private static SerieFacade instance;

	public static SerieFacade getInstance() {
		if ( instance == null ) {
			instance = new SerieFacade();
		}
		return instance;
	}

	public void salvar( SeriePO po ) {
		service.salvar( po );
	}

	public void alterar( SeriePO po ) {
		service.alterar( po );
	}

	public List< SeriePO > filtrar( SeriePO po ) {
		return service.filtrar( po );
	}

	public void excluir( SeriePO po ) {
		service.excluir( po );
	}

}
