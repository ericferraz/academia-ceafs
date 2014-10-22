package br.com.ceafssystem.business.instrutor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.Criptografia;
import br.com.ceafssystem.dao.instrutor.InstrutorDAO;
import br.com.ceafssystem.dao.usuario.UsuarioDAO;
import br.com.ceafssystem.domain.pessoa.InstrutorPO;
import br.com.ceafssystem.domain.pessoa.UsuarioPO;

@Service
public class InstrutorService{

	@Autowired
	private InstrutorDAO dao;
	
	@Autowired
	private UsuarioDAO usuarioDao;

	public void salvar( InstrutorPO po ) {
		UsuarioPO usuario = new UsuarioPO();
		usuario.setLogin( "funcionario" );
		usuario.setSenha( Criptografia.encripta( "funcionario" ) );
		usuario.setTipoUsuario( "FUNCIONARIO" );

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

	public void alterar( InstrutorPO po ) {
		this.dao.alterar( po );
	}

	public List< InstrutorPO > filtrar( InstrutorPO po ) {
		try {
			return this.dao.filtrar( po );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir( InstrutorPO po ) {
		this.dao.excluir( po );
	}

}
