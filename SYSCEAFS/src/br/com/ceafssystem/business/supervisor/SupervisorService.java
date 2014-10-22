package br.com.ceafssystem.business.supervisor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.Criptografia;
import br.com.ceafssystem.dao.supervisor.SupervisorDAO;
import br.com.ceafssystem.dao.usuario.UsuarioDAO;
import br.com.ceafssystem.domain.pessoa.SupervisorPO;
import br.com.ceafssystem.domain.pessoa.UsuarioPO;

@Service
public class SupervisorService{

	@Autowired
	private SupervisorDAO dao;

	@Autowired
	private UsuarioDAO usuarioDao;

	public void salvar( SupervisorPO po ) {

		UsuarioPO usuario = new UsuarioPO();
		usuario.setLogin( "admin" );
		usuario.setSenha( Criptografia.encripta( "admin" ) );
		usuario.setTipoUsuario( "ADMINISTRADOR" );

		try {
			if(this.usuarioDao.filtrar( usuario ) == null)
				this.usuarioDao.inserir( usuario );
			else{
			List< UsuarioPO >usuarios = this.usuarioDao.filtrar( usuario );
			usuario = usuarios.get( 0 );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		po.getFuncionario().setUsuario( usuario );

		this.dao.inserir( po );
	}

	public void alterar( SupervisorPO po ) {
		this.dao.alterar( po );
	}

	public List< SupervisorPO > filtrar( SupervisorPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( SupervisorPO po ) {
		this.dao.excluir( po );
	}

}
