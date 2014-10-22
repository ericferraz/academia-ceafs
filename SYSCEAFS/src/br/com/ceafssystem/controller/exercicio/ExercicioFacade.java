package br.com.ceafssystem.controller.exercicio;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.exercicio.ExercicioService;
import br.com.ceafssystem.domain.exercicio.ExercicioPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class ExercicioFacade{

	private static ExercicioService service;

	static {
		service = new AnnotationConfigApplicationContext( ExercicioFacade.class ).getBean( ExercicioService.class );
	}

	private static ExercicioFacade instance;

	public static ExercicioFacade getInstance() {
		if ( instance == null ) {
			instance = new ExercicioFacade();
		}
		return instance;
	}

	public void salvar( ExercicioPO po ) {
		service.salvar( po );
	}

	public void alterar( ExercicioPO po ) {
		service.alterar( po );
	}

	public List< ExercicioPO > filtrar( ExercicioPO po ) {
		return service.filtrar( po );
	}

	public void excluir( ExercicioPO po ) {
		service.excluir( po );
	}

}
