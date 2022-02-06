package DAO;

import Factory.ConnectionFactory;
import Model.CategoriaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class EditarCategoriaDAO {

    private Connection connection;

    public EditarCategoriaDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }

    public String editarTabela(){
        Scanner sc1 = new Scanner(System.in);sc1.useLocale(Locale.US);
        CategoriaModel categoria1 = new CategoriaModel();
        System.out.println("Insira o nome do gênero que quer editar na tabela");
        String nomeCategoriaOriginal = sc1.nextLine();
        System.out.println("Insira o novo nome");
        categoria1.setNomeCategoria(sc1.nextLine());


        String QUERY = "UPDATE categorias SET nomeCategoria = ? WHERE nomeCategoria = ?";
        try{

            PreparedStatement stmt = connection.prepareStatement(QUERY);
            stmt.setString(1, categoria1.getNomeCategoria());
            stmt.setString(2,nomeCategoriaOriginal);
            stmt.execute();

            System.out.println("Alteração feita com sucesso");
            String mensagem = String.format("'%s' foi substituído por '%s'",nomeCategoriaOriginal,categoria1.getNomeCategoria());
            System.out.println(mensagem);

        }catch(SQLException e){

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
        return nomeCategoriaOriginal;
    }
}

