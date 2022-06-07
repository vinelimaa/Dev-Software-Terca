package br.edu.up;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Programa {

	public static void main(String[] args) throws SQLException {				
		incluir();		
		//atualizar();
		//apagar();
		//listar();
	}
	
	
	public static void incluir() throws SQLException {
		//1. Abrir conex�o com o banco de dados;
		String url = "jdbc:sqlite:/home/vinicius/Desktop/git/Dev-Software-Terca/ExSQLite/db/primeiro_banco_de_dados.db";		
		Connection conexao = DriverManager.getConnection(url);
		
		//2. Criar banco de dados;
		Statement drop = conexao.createStatement();
		String queryDrop = 
				"drop table if exists cliente";
		drop.execute(queryDrop);
		
		//Statement create = conexao.createStatement();
		//String queryCreate = 
				//"create table cliente ("
				//+ "nome varchar(50), dta_nasc char(10), cpf integer(11), email varchar(50))";
		//create.execute(queryCreate);
		
		//3. Criar o comando e executar o SQL;
		Statement comando = conexao.createStatement();
		String queryInsert = 
				"insert into cliente (nome, dta_nasc, cpf, email) "
				+ " values ('Vini', '2000/06/23', '7654321', 'vini@gmail.com')";
		comando.execute(queryInsert);
	}
	
	
	public static void listar() throws SQLException {
		//1. Abrir conex�o com o banco de dados;
		String url = "jdbc:sqlite:/home/vinicius/Desktop/git/Dev-Software-Terca/ExSQLite/db/primeiro_banco_de_dados.db";		
		Connection conexao = DriverManager.getConnection(url);
		
		//2. Criar o comando e executar o SQL;
		Statement comando = conexao.createStatement();
		String querySelect = "select * from cliente";
		ResultSet resultado = comando.executeQuery(querySelect);
		
		//3. Mostrar os dados;
		while(resultado.next()) {
			int codigo = resultado.getInt(1);
			String nome = resultado.getString(2);
			String dtaNasc = resultado.getString(3);
			String cpf = resultado.getString(4);
			String email = resultado.getString(5);
			
			System.out.println("C�digo: " + codigo);
			System.out.println("Nome: " + nome);
			System.out.println("------------------");			
		}
	}
	
	
	public static void atualizar() throws SQLException {
		//1. Abrir conex�o com o banco de dados;
		String url = "jdbc:sqlite:/home/vinicius/Desktop/git/Dev-Software-Terca/ExSQLite/db/primeiro_banco_de_dados.db";		
		Connection conexao = DriverManager.getConnection(url);
		
		//2. Criar o comando e executar o SQL;
		Statement comando = conexao.createStatement();
		String queryUpdate = 
				"update cliente set nome = 'Ricardo' "
				+ " where codigo = 3";
		comando.executeUpdate(queryUpdate);
	}
	
	public static void apagar() throws SQLException {
		//1. Abrir conex�o com o banco de dados;
		String url = "jdbc:sqlite:/home/vinicius/Desktop/git/Dev-Software-Terca/ExSQLite/db/primeiro_banco_de_dados.db";		
		Connection conexao = DriverManager.getConnection(url);
		
		//2. Criar o comando e executar o SQL;
		Statement comando = conexao.createStatement();
		String queryDelete = 
				"delete from cliente where codigo = 5";
		comando.execute(queryDelete);
	}

}
