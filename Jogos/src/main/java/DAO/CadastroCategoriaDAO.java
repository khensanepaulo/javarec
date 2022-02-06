package DAO;

import Factory.ConnectionFactory;
import Model.CategoriaModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroCategoriaDAO {

    private Connection connection;
    public CadastroCategoriaDAO(){this.connection = new ConnectionFactory().getConnection();}



    public void criarTabelaDeCategorias()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Categorias" +
                "(IdCategoria int UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT,nomeCategoria varchar(255));";

        try {


            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String cadastrarCategorias() {

        Scanner sc1 = new Scanner(System.in);
        CategoriaModel categoriaModel = new CategoriaModel();

        System.out.println("Insira o nome do gênero que quer adicionar a tabela");
        categoriaModel.setNomeCategoria(sc1.nextLine());



        String temp = "";
        String QUERY = "INSERT INTO Categorias(nomeCategoria) VALUES (?)";

        try{

            PreparedStatement stmt = connection.prepareStatement(QUERY);
            stmt.setString(1, categoriaModel.getNomeCategoria());
            stmt.execute();

            System.out.println("Alteração feita com sucesso");
            String mensagem = String.format("o gênero '%s' foi adicionado a tabela",categoriaModel.getNomeCategoria());
            System.out.println(mensagem);
            System.out.println("\n");


        }
        catch(SQLException e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return temp;
    }


}

