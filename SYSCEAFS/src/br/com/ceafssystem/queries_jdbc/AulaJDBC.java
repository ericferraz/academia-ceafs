package br.com.ceafssystem.queries_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ceafssystem.controller.aula.SerieFacade;
import br.com.ceafssystem.domain.atividade.AtividadePO;
import br.com.ceafssystem.domain.aula.AulaPO;
import br.com.ceafssystem.domain.aula.SeriePO;
import br.com.ceafssystem.domain.pessoa.AlunoPO;
import br.com.ceafssystem.domain.pessoa.FuncionarioPO;
import br.com.ceafssystem.domain.pessoa.InstrutorPO;
import br.com.ceafssystem.domain.pessoa.PessoaPO;

/**
 * 
 * Classe que representa a versão JDBC ds métodos listar e deletar de Aula
 * Quando uso o listar do hibernate tenho o seguinte erro:
 * org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch multiple bags
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 02/06/2014 02:27:33
 * @version 1.0
 */
public class AulaJDBC{

	public ArrayList< AulaPO > listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append( "SELECT au.id, au.data_aula, atv.dia_da_semana, au.pressao_inicial, au.pressao_final, " );
		sql.append( "(SELECT nome FROM pessoa WHERE a.id_pessoa = pessoa.id) AS nome_aluno, " );
		sql.append( "(SELECT nome FROM pessoa WHERE i.id_funcionario = pessoa.id) AS nome_instrutor " );
		sql.append( "FROM aula au " );
		sql.append( "INNER JOIN atividade atv ON (au.id_atividade = atv.id) " );
		sql.append( "INNER JOIN aluno a ON (atv.id_aluno = a.id) " );
		sql.append( "INNER JOIN instrutor i ON (au.id_instrutor = i.id); " );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement( sql.toString() );

		ResultSet resultado = comando.executeQuery();

		ArrayList< AulaPO > itens = new ArrayList< AulaPO >();

		while ( resultado.next() ) {

			AulaPO aula = new AulaPO();
			aula.setId( resultado.getLong( "au.id" ) );
			aula.setDataAula( resultado.getDate( "au.data_aula" ) );
			aula.setPressaoInicial( resultado.getString( "au.pressao_inicial" ) );
			aula.setPressaoFinal( resultado.getString( "au.pressao_final" ) );

			PessoaPO pessoa = new PessoaPO();
			AlunoPO aluno = new AlunoPO();
			pessoa.setNome( resultado.getString( "nome_aluno" ) );
			aluno.setPessoa( pessoa );

			AtividadePO atividade = new AtividadePO();
			atividade.setDiaDaSemana( resultado.getString( "atv.dia_da_semana" ) );
			atividade.setAluno( aluno );

			FuncionarioPO funcionario = new FuncionarioPO();
			InstrutorPO instrutor = new InstrutorPO();
			funcionario.setNome( resultado.getString( "nome_instrutor" ) );
			instrutor.setFuncionario( funcionario );

			aula.setAtividade( atividade );

			aula.setInstrutor( instrutor );

			itens.add( aula );

		}

		return itens;
	}

	public static void main( String[ ] args ) {
		/*AulaJDBC consulta = new AulaJDBC();

		try {
			ArrayList< AulaPO > lista = consulta.listar();

			for ( AulaPO aulaPO : lista ) {
				System.out.println( "Resultado: " + aulaPO );
				System.out.println(aulaPO.getInstrutor().getFuncionario().getNome());
			}

		} catch ( SQLException e ) {
			System.out.println( "Ocorreu um erro ao tentar listar as aulas!" );
			e.printStackTrace();
		}*/

		SeriePO po = new SeriePO();
		SerieFacade.getInstance().filtrar( po );
	}

}
