package br.com.ceafssystem.queries_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ceafssystem.domain.atividade.AtividadeExercicioPO;
import br.com.ceafssystem.domain.aula.AulaExercicioPO;
import br.com.ceafssystem.domain.aula.SeriePO;
import br.com.ceafssystem.domain.exercicio.ExercicioPO;

/**
 * 
 * Classe que representa a versão JDBC ds métodos listar e deletar de Serie
 * Quando uso o listar do hibernate tenho o seguinte erro:
 * org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch multiple bags
 *
 * @author Leticia Pereira Borges Alves <leticia_borges.alves@hotmail.com>
 * @since 02/06/2014 02:27:33
 * @version 1.0
 */
public class SerieJDBC{

	public ArrayList< SeriePO > listarPorDataAtual( Long id ) throws SQLException {
		StringBuilder sql = new StringBuilder();
		/*sql.append( "SELECT s.id, s.descricao, s.carga_direita, s.carga_esquerda " );
		sql.append( "FROM serie s " );
		sql.append( "WHERE s.id_aluno = ? AND s.data_aula = CURRENT_DATE(); " );*/

		/* Sem o DISTINCT ele mostrava cada série 2 vezes */
		sql.append( "SELECT DISTINCT s.id, e.nome, s.descricao, s.carga_direita, s.carga_esquerda " );
		sql.append( "FROM serie s " );
		sql.append( "INNER JOIN aula_exercicio ae ON s.id_aula_exercicio = ae.id " );
		sql.append( "INNER JOIN atividade_exercicio ate ON ae.id_atividade_exercicio = ate.id " );
		sql.append( "INNER JOIN exercicio e	ON ate.id_exercicio = e.id " );
		sql.append( "WHERE s.id_aluno = ? AND s.data_aula = CURRENT_DATE(); " );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement( sql.toString() );
		comando.setLong( 1, id );

		ResultSet resultado = comando.executeQuery();

		ArrayList< SeriePO > itens = new ArrayList< SeriePO >();

		while ( resultado.next() ) {

			SeriePO serie = new SeriePO();

			serie.setId( resultado.getLong( "s.id" ) );
			serie.setDescricao( resultado.getString( "s.descricao" ) );
			serie.setCargaDireita( resultado.getString( "s.carga_direita" ) );
			serie.setCargaEsquerda( resultado.getString( "s.carga_esquerda" ) );
			serie.setSituacao( Boolean.FALSE );

			ExercicioPO exercicio = new ExercicioPO();
			exercicio.setNome( resultado.getString( "e.nome" ) );

			AtividadeExercicioPO atividadeExercicio = new AtividadeExercicioPO();
			atividadeExercicio.setExercicio( exercicio );

			AulaExercicioPO aulaExercicio = new AulaExercicioPO();
			aulaExercicio.setAtividadeExercicio( atividadeExercicio );

			serie.setAulaExercicio( aulaExercicio );

			itens.add( serie );

		}

		return itens;
	}

	/*public ArrayList< SeriePO > listarTodasSeriesAluno( Long id ) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append( "SELECT s.id, s.descricao, s.carga_direita, s.carga_esquerda " );
		sql.append( "FROM serie s " );
		sql.append( "WHERE s.id_aluno = ? AND s.data_aula = CURRENT_DATE(); " );
		
		sql.append( "SELECT s.id, s.carga_direita, s.carga_esquerda, s.data_aula ");
		sql.append( "FROM serie s ");
		sql.append( "INNER JOIN aula_exercicio ae ON s.id_aula_exercicio = ae.id ");
		sql.append( "INNER JOIN atividade_exercicio ate ON ae.id_atividade_exercicio = ate.id_exercicio ");
		sql.append( "INNER JOIN exercicio e	ON ate.id_exercicio = e.id ");
		sql.append( "WHERE s.id_aluno = ? ;");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement( sql.toString() );
		comando.setLong( 1, id );

		ResultSet resultado = comando.executeQuery();

		ArrayList< SeriePO > itens = new ArrayList< SeriePO >();

		while ( resultado.next() ) {

			SeriePO serie = new SeriePO();

			serie.setId( resultado.getLong( "s.id" ) );
			serie.setCargaDireita( resultado.getString( "s.carga_direita" ) );
			serie.setCargaEsquerda( resultado.getString( "s.carga_esquerda" ) );
			serie.setDataAula( resultado.getDate( "s.data_aula" ) );
			
			itens.add( serie );

		}

		return itens;
	}

	public static void main( String[ ] args ) {
		SerieJDBC consulta = new SerieJDBC();

		try {
			ArrayList< SeriePO > lista = consulta.listarPorDataAtual( 1L );
			ArrayList< SeriePO > listaTodas = consulta.listarTodasSeriesAluno(1L);

			for ( SeriePO seriePO : lista ) {
				System.out.println( "Resultado: " + seriePO );
			}
			
			System.out.println();
			
			for ( SeriePO seriePO : listaTodas ) {
				System.out.println( "Resultado: " + seriePO );
			}


		} catch ( SQLException e ) {
			System.out.println( "Ocorreu um erro ao tentar listar as aulas!" );
			e.printStackTrace();
		}

	}*/

	public ArrayList< SeriePO > listarTodasSeriesAluno( Long id, Long idEx ) throws SQLException {
		StringBuilder sql = new StringBuilder();
		/*sql.append( "SELECT s.id, s.descricao, s.carga_direita, s.carga_esquerda " );
		sql.append( "FROM serie s " );
		sql.append( "WHERE s.id_aluno = ? AND s.data_aula = CURRENT_DATE(); " );*/

		sql.append( "SELECT s.id, e.nome, s.descricao, s.carga_direita, s.carga_esquerda, s.data_aula " );
		sql.append( "FROM serie s " );
		sql.append( "INNER JOIN aula_exercicio ae ON s.id_aula_exercicio = ae.id " );
		sql.append( "INNER JOIN atividade_exercicio ate ON ae.id_atividade_exercicio = ate.id " );
		sql.append( "INNER JOIN exercicio e	ON ate.id_exercicio = e.id " );
		sql.append( "WHERE s.id_aluno = ? AND e.id = ? AND s.descricao='Série 5 - Avaliação' ORDER BY s.data_aula;" );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement( sql.toString() );
		comando.setLong( 1, id );
		comando.setLong( 2, idEx );

		ResultSet resultado = comando.executeQuery();

		ArrayList< SeriePO > itens = new ArrayList< SeriePO >();

		while ( resultado.next() ) {

			SeriePO serie = new SeriePO();

			serie.setId( resultado.getLong( "s.id" ) );
			serie.setDescricao( resultado.getString( "s.descricao" ) );
			serie.setCargaDireita( resultado.getString( "s.carga_direita" ) );
			serie.setCargaEsquerda( resultado.getString( "s.carga_esquerda" ) );
			serie.setDataAula( resultado.getDate( "s.data_aula" ) );

			ExercicioPO exercicio = new ExercicioPO();
			exercicio.setNome( resultado.getString( "e.nome" ) );

			AtividadeExercicioPO atividadeExercicio = new AtividadeExercicioPO();
			atividadeExercicio.setExercicio( exercicio );

			AulaExercicioPO aulaExercicio = new AulaExercicioPO();
			aulaExercicio.setAtividadeExercicio( atividadeExercicio );

			serie.setAulaExercicio( aulaExercicio );

			itens.add( serie );

		}

		return itens;
	}

	public static void main( String[ ] args ) {
		SerieJDBC consulta = new SerieJDBC();

		try {
			ArrayList< SeriePO > lista = consulta.listarPorDataAtual( 1L );
			ArrayList< SeriePO > listaTodas = consulta.listarTodasSeriesAluno( 1L, 1L );

			for ( SeriePO seriePO : lista ) {
				System.out.println( "Resultado: " + seriePO );
			}

			System.out.println();

			for ( SeriePO seriePO : listaTodas ) {
				System.out.println( "Resultado: " + seriePO );
			}

		} catch ( SQLException e ) {
			System.out.println( "Ocorreu um erro ao tentar listar as aulas!" );
			e.printStackTrace();
		}

	}

}
