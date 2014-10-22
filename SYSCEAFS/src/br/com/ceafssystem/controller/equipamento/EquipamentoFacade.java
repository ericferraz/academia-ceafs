package br.com.ceafssystem.controller.equipamento;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.ceafssystem.business.equipamento.EquipamentoService;
import br.com.ceafssystem.domain.equipamento.EquipamentoPO;

@Controller
@ComponentScan( basePackages = "br.com.*" )
public class EquipamentoFacade{

	private static EquipamentoService service;

	static {
		service = new AnnotationConfigApplicationContext( EquipamentoFacade.class ).getBean( EquipamentoService.class );
	}

	private static EquipamentoFacade instance;

	public static EquipamentoFacade getInstance() {
		if ( instance == null ) {
			instance = new EquipamentoFacade();
		}
		return instance;
	}

	public void salvar( EquipamentoPO po ) {
		service.salvar( po );
	}

	public void alterar( EquipamentoPO po ) {
		service.alterar( po );
	}

	public List< EquipamentoPO > filtrar( EquipamentoPO po ) {
		return service.filtrar( po );
	}

	public void excluir( EquipamentoPO po ) {
		service.excluir( po );
	}

}
