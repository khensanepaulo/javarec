package DAO;

import Factory.ConnectionFactory;
import Model.EmpresaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroEmpresaDAO {

    private Connection connection;

    public CadastroEmpresaDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }






    public void criarTabelaDeEmpresas()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Empresas" +
                "(IdEmpresa int UNIQUE NOT NULL PRIMARY KEY AUTO_INCREMENT,nomeEmpresa varchar(255));";

        try {


            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String cadastrarEmpresa() {

        Scanner sc1 = new Scanner(System.in);
        EmpresaModel empresaModel = new EmpresaModel();


        System.out.println("Insira o nome da empresa que quer adicionar a tabela");
        empresaModel.setNomeEmpresa(sc1.nextLine());



        String temp = "";
        String QUERY = "INSERT INTO Empresas(nomeEmpresa) VALUES (?)";

        try{


            PreparedStatement stmt = connection.prepareStatement(QUERY);
            stmt.setString(1, empresaModel.getNomeEmpresa());
            stmt.execute();

            System.out.println("Alteração feita com sucesso");
            String mensagem = String.format("'%s' foi adicionada  a tabela",empresaModel.getNomeEmpresa());
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


