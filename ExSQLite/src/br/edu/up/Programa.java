package br.edu.up;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.sql.ResultSet;

class Filme{
	static String titulo;
	static String genero;
	static int ano;
	static String classf;
	static int op = 0;
	static int id = 0;
	static String querySelect;
}

public class Programa {

	public static void main(String[] args) throws SQLException {
		
		menu();
		
	}
	
	public static void incluir() throws SQLException {
		Scanner leitor = new Scanner(System.in);
	
		System.out.println("\n ________________________");
		System.out.println("|___ ÁREA DE CADASTRO ___|");
		System.out.println("\nINSIRA O TÍTULO DO FILME: ");
		Filme.titulo = leitor.nextLine();
		System.out.println("INSIRA O GÊNERO DO FILME: ");
		Filme.genero = leitor.nextLine();
		System.out.println("INSIRA O ANO DO FILME: ");
		Filme.ano = leitor.nextInt();
		leitor.nextLine();
		System.out.println("INSIRA A CLASSIFICAÇÃO DO FILME: ");
		Filme.classf = leitor.nextLine();
		
		//1. Abrir conexão com o banco de dados;
		Connection con = getConnection();
		
		//2. Criar o comando e executar o SQL;
		Statement comando = con.createStatement();
		
		String sql = "INSERT INTO `filmes`(`titulo`, `genero`, `ano`, `classificacao`) VALUES (?,?,?,?);";

		PreparedStatement executor = con.prepareStatement(sql);
		executor.setString(1, Filme.titulo);
		executor.setString(2, Filme.genero);
		executor.setInt(3, Filme.ano);
		executor.setString(4, Filme.classf);
		
		executor.executeUpdate();
		executor.close();
		con.close();
		
		System.out.println("\n------------------------------");
		System.out.println(" FILME CADASTRADO COM SUCESSO!");
		System.out.println("------------------------------");
		System.out.println("\n _______________________");
		System.out.println("|1-CADASTRAR NOVO FILME |\n|___2-VOLTAR AO MENU____|");
		Filme.op = leitor.nextInt();
		leitor.nextLine();
		if(Filme.op==1){
			incluir();
		}
		else if(Filme.op==2){
			menu();
		}
		else {
			System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
		}
	}
	
	public static void listar() throws SQLException {
		Scanner leitor = new Scanner(System.in);
		String insert = "start";
		
		//1. Abrir conexão com o banco de dados;
		Connection con = getConnection();
		
		//2. Criar o comando e executar o SQL;
		Statement comando = con.createStatement();
		System.out.println("\n ______________________");
		System.out.println("|____ BUSCAR FILME ____|");
		System.out.println("\n1 - TÍTULO");
		System.out.println("2 - GÊNERO");
		System.out.println("3 - ANO");
		System.out.println("4 - CLASSIFICAÇÃO");
		System.out.println("5 - BUSCAR TODOS OS FILMES");
		Filme.op = leitor.nextInt();
		leitor.nextLine();
		
		if(Filme.op==1) {
			System.out.println("\n _______________________");
			System.out.println("|___ BUSCA POR TÍTULO___|");
			System.out.println("\nInsira o Título do filme, ou parte do título que deseja buscar: ");
			System.out.println("Ex:(velozes, Tokio, Jurassic, Ilha, poderoso, o, em).");
			insert = leitor.nextLine();
			Filme.querySelect = "SELECT * FROM filmes WHERE titulo LIKE '%" + insert + "%';";
			
			mostrar();
			novaBusca();
		}
		else if(Filme.op==2){
			System.out.println("\n _______________________");
			System.out.println("|___ BUSCA POR GÊNERO ___|");
			System.out.println("\nInsira o Gênero do filme, ou parte do gênero que deseja buscar: ");
			System.out.println("Ex:(aventura, comédia, ação, susp, cient, terr).");
			insert = leitor.nextLine();
			Filme.querySelect = "SELECT * FROM filmes WHERE genero LIKE '%" + insert + "%';";
			
			mostrar();
			novaBusca();
		}
		else if(Filme.op==3){
			System.out.println("\n ____________________");
			System.out.println("|___ BUSCA POR ANO ___|");
			System.out.println("\nInsira o Ano do filme, ou parte do ano que deseja buscar: ");
			System.out.println("Ex:(2013, 1999, 20, 95, 19.)");
			insert = leitor.nextLine();
			Filme.querySelect = "SELECT * FROM filmes WHERE ano LIKE '%" + insert + "%';";

			mostrar();
			novaBusca();
		}
		else if(Filme.op==4){
			System.out.println("\n _______________________________");
			System.out.println("|___ BUSCA POR CLASSIFICAÇÃO ___|");
			System.out.println("\nInsira a Classificação do filme que deseja buscar: ");
			System.out.println("Ex:(10, 16, 18, Livre).");
			insert = leitor.nextLine();
			Filme.querySelect = "SELECT * FROM filmes WHERE classificacao LIKE '%" + insert + "%';";

			mostrar();
			novaBusca();
		}
		else if(Filme.op==5){
			System.out.println("\n ______________________________");
			System.out.println("|___ BUSCAR TODOS OS FILMES ___|");
			
			Filme.querySelect = "SELECT * FROM filmes;";

			mostrar();
			novaBusca();
		}
	}
	
	public static void atualizar() throws SQLException {
		Scanner leitor = new Scanner(System.in);
		
		//1. Abrir conexão com o banco de dados;
		Connection con = getConnection();
		
		//2. Criar o comando e executar o SQL;
		Statement comando = con.createStatement();
		
		System.out.println("\n _______________________");
		System.out.println("|____ ALTERAR FILME ____|");
		System.out.println("\n1 - ALTERAR FILME POR ID");
		System.out.println("0 - VOLTAR");
		Filme.op = leitor.nextInt();
		leitor.nextLine();
		if(Filme.op==1) {
			System.out.println("INSIRA O ID DO FILME QUE DESEJA ALTERAR: ");
			Filme.id = leitor.nextInt();
			Filme.querySelect = "SELECT * FROM filmes WHERE id = "+ Filme.id +";";
			mostrar();
			System.out.println("DESEJA ALTERAR ESTE FILME?");
			System.out.println("\n1 - ALTERAR\n0 - VOLTAR");
			Filme.op = leitor.nextInt();
			leitor.nextLine();
			if(Filme.op==1) {
				System.out.println(" _________________");
				System.out.println("|____ ALTERAR ____|");
				System.out.println("\n1 - TÍTULO");
				System.out.println("2 - GÊNERO");
				System.out.println("3 - ANO");
				System.out.println("4 - CLASSIFICAÇÃO");
				System.out.println("5 - ALTERAR TODOS OS CAMPOS");
				Filme.op = leitor.nextInt();
				leitor.nextLine();
				if(Filme.op==1) {
					System.out.println("\nINSIRA O NOVO TÍTULO DO FILME: ");
					Filme.titulo = leitor.nextLine();
					Filme.querySelect = "UPDATE `filmes` SET `titulo` = ?"
							+ "WHERE `id` = "+ Filme.id +";";
					PreparedStatement executor = con.prepareStatement(Filme.querySelect);
					executor.setString(1, Filme.titulo);
					executor.executeUpdate();
					executor.close();
					con.close();
					System.out.println("\n------------------------------");
					System.out.println(" TÍTULO ALTERADO COM SUCESSO!");
					System.out.println("------------------------------");
					System.out.println("\n0 - VOLTAR");
					Filme.op = leitor.nextInt();
					leitor.nextLine();
					if(Filme.op==0){
						atualizar();
					}
					else {
						System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
					}
				}
				else if(Filme.op==2) {
					System.out.println("INSIRA O NOVO GÊNERO DO FILME: ");
					Filme.genero = leitor.nextLine();
					Filme.querySelect = "UPDATE `filmes` SET `genero` = ?"
							+ "WHERE `id` = "+ Filme.id +";";
					PreparedStatement executor = con.prepareStatement(Filme.querySelect);
					executor.setString(1, Filme.genero);
					executor.executeUpdate();
					executor.close();
					con.close();
					System.out.println("\n------------------------------");
					System.out.println(" GÊNERO ALTERADO COM SUCESSO!");
					System.out.println("------------------------------");
					System.out.println("\n0 - VOLTAR");
					Filme.op = leitor.nextInt();
					leitor.nextLine();
					if(Filme.op==0){
						atualizar();
					}
					else {
						System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
					}
				}
				else if(Filme.op==3) {
					System.out.println("INSIRA O NOVO ANO DO FILME: ");
					Filme.ano = leitor.nextInt();
					leitor.nextLine();
					Filme.querySelect = "UPDATE `filmes` SET `ano` = ?"
							+ "WHERE `id` = "+ Filme.id +";";
					PreparedStatement executor = con.prepareStatement(Filme.querySelect);
					executor.setInt(1, Filme.ano);
					executor.executeUpdate();
					executor.close();
					con.close();
					System.out.println("\n------------------------------");
					System.out.println(" ANO ALTERADO COM SUCESSO!");
					System.out.println("------------------------------");
					System.out.println("\n0 - VOLTAR");
					Filme.op = leitor.nextInt();
					leitor.nextLine();
					if(Filme.op==0){
						atualizar();
					}
					else {
						System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
					}
				}
				else if(Filme.op==4) {
					System.out.println("INSIRA A NOVA CLASSIFICAÇÃO DO FILME: ");
					Filme.classf = leitor.nextLine();
					Filme.querySelect = "UPDATE `filmes` SET `classificacao` = ?"
							+ "WHERE `id` = "+ Filme.id +";";
					PreparedStatement executor = con.prepareStatement(Filme.querySelect);
					executor.setString(1, Filme.classf);
					executor.executeUpdate();
					executor.close();
					con.close();
					System.out.println("\n------------------------------------");
					System.out.println(" CLASSIFICAÇÃO ALTERADA COM SUCESSO!");
					System.out.println("------------------------------------");
					System.out.println("\n0 - VOLTAR");
					Filme.op = leitor.nextInt();
					leitor.nextLine();
					if(Filme.op==0){
						atualizar();
					}
					else {
						System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
					}
				}
				else if(Filme.op==5) {
					System.out.println("\nINSIRA O NOVO TÍTULO DO FILME: ");
					Filme.titulo = leitor.nextLine();
					System.out.println("INSIRA O NOVO GÊNERO DO FILME: ");
					Filme.genero = leitor.nextLine();
					System.out.println("INSIRA O NOVO ANO DO FILME: ");
					Filme.ano = leitor.nextInt();
					leitor.nextLine();
					System.out.println("INSIRA A NOVA CLASSIFICAÇÃO DO FILME: ");
					Filme.classf = leitor.nextLine();
					
					Filme.querySelect = "UPDATE `filmes` SET `titulo` = ?,"
							+ "`genero` = ?, `ano` = ?, `classificacao` = ?"
							+ "WHERE `id` = "+ Filme.id +";";
					
					PreparedStatement executor = con.prepareStatement(Filme.querySelect);
					executor.setString(1, Filme.titulo);
					executor.setString(2, Filme.genero);
					executor.setInt(3, Filme.ano);
					executor.setString(4, Filme.classf);
					
					executor.executeUpdate();
					executor.close();
					con.close();
					
					System.out.println("\n-------------------------------");
					System.out.println(" CADASTRO ALTERADO COM SUCESSO!");
					System.out.println("-------------------------------");
					System.out.println("\n0 - VOLTAR");
					Filme.op = leitor.nextInt();
					leitor.nextLine();
					if(Filme.op==0){
						atualizar();
					}
					else {
						System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
					}
				}
			}
			else if(Filme.op==0) {
				atualizar();
			}	
		}
		else if(Filme.op==0) {
			menu();
		}
		
		//String queryUpdate = 
			//	"UPDATE filmes SET titulo = '"+ Filme.titulo +"' WHERE id = 3;";
		
	//	comando.executeUpdate(queryUpdate);
	}
	
	public static void apagar() throws SQLException {
		Scanner leitor = new Scanner(System.in);
		
		//1. Abrir conex�o com o banco de dados;
		String url = "jdbc:sqlite:C:\\Users\\Vinicius\\Documents\\Dev-Software-Terca\\ExSQLite\\db\\museu_do_filme.db";		
		Connection conexao = DriverManager.getConnection(url);
		
		//2. Criar o comando e executar o SQL;
		Statement comando = conexao.createStatement();
		String queryDelete = 
				"delete from cliente where codigo = 5";
		comando.execute(queryDelete);
	}
	public static void menu() throws SQLException {
		Scanner leitor = new Scanner(System.in);
		int op = 0;
		
		do {
			System.out.println(" ________________________________");
			System.out.println("|__ BEM VINDO AO MUSEU DO FILME__|");
			System.out.println("\n\t     MENU ");
			System.out.println("\n    1 - CADASTRAR NOVO FILME\n    2 - ALTERAR FILME"
					+ "\n    3 - EXCLUIR FILME\n    4 - BUSCAR FILME\n\n    0 - SAIR");
			op = leitor.nextInt();
			if(op != 1 && op != 2 &&  op != 3 && op != 4 && op != 0) {
				System.out.println("\nOPÇÃO INVÁLIDA!\n\n");
			}
		}while(op != 1 && op != 2 &&  op != 3 && op != 4 && op != 0);
			
		if (op == 1) {
			incluir();
		}
		else if (op == 2) {
			atualizar();
		}
		else if (op == 3) {
			apagar();	
		}
		else if (op == 4) {
			listar();
		}
		else if (op == 0) {
			System.exit(0);
		}
	}
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlite:C:\\Users\\Vinicius\\Documents\\Dev-Software-Terca\\ExSQLite\\db\\museu_do_filme.db";		
		Connection con = DriverManager.getConnection(url);
		
		return con;
	}
	
	public static void mostrar() throws SQLException {
		Statement comando = getConnection().createStatement();
		ResultSet resultado = comando.executeQuery(Filme.querySelect);
		
		System.out.println("\n------------------------------------");
		System.out.println("        RESULTADO DA BUSCA          ");
		System.out.println("------------------------------------");
		//3. Mostrar os dados;
		while(resultado.next()) {
			Filme.id = resultado.getInt(1);
			Filme.titulo = resultado.getString(2);
			Filme.genero = resultado.getString(3);
			Filme.ano = resultado.getInt(4);
			Filme.classf = resultado.getString(5);
			
			System.out.println("ID: " 	     	 + Filme.id);
			System.out.println("TÍTULO: " 	     + Filme.titulo);
			System.out.println("GÊNERO: "		 + Filme.genero);
			System.out.println("ANO: " 	  		 + Filme.ano);
			System.out.println("CLASSIFICAÇÃO: " + Filme.classf);
			System.out.println("------------------------------------");			
		}
	}
	public static void novaBusca() throws SQLException {
		Scanner leitor = new Scanner(System.in);
		System.out.println("\nDESEJA REALIZAR UMA NOVA BUSCA?");
		System.out.println("1-SIM     2-VOLTAR AO MENU");
		Filme.op = leitor.nextInt();
		leitor.nextLine();
		if(Filme.op==1){
			listar();
		}
		else if(Filme.op==2){
			menu();
		}
		else {
			System.out.println("\nERRO! DIGITE UMA OPÇÃO VÁLIDA!");
		}
	}
}