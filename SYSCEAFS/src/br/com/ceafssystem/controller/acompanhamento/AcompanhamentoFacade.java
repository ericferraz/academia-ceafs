package br.com.ceafssystem.controller.acompanhamento;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.acompanhamento.AcompanhamentoService;
import br.com.ceafssystem.domain.patologia.AcompanhamentoPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class AcompanhamentoFacade{

	private static AcompanhamentoService service;

	static {
		service = new AnnotationConfigApplicationContext( AcompanhamentoFacade.class ).getBean( AcompanhamentoService.class );
	}

	private static AcompanhamentoFacade instance;

	public static AcompanhamentoFacade getInstance() {
		if ( instance == null ) {
			instance = new AcompanhamentoFacade();
		}
		return instance;
	}

	public void salvar( AcompanhamentoPO po ) {
		service.salvar( po );
	}

	public void alterar( AcompanhamentoPO po ) {
		service.alterar( po );
	}

	public List< AcompanhamentoPO > filtrar( AcompanhamentoPO po ) {
		return service.filtrar( po );
	}

	public void excluir( AcompanhamentoPO po ) {
		service.excluir( po );
	}

}
