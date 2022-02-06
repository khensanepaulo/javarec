package DAO;


import Factory.ConnectionFactory;

import java.sql.*;
import java.util.Scanner;


public class ListarJogosCategoriaDAO {

    private Connection connection;

    public ListarJogosCategoriaDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }

    public String ListarJogosDoCategoria() {


        Scanner sc1 = new Scanner(System.in);
        System.out.println("Digite o ID da categoria desejado");
        int id = sc1.nextInt();
        String QUERY = String.format("SELECT * FROM jogos WHERE idCategoria = %d", id);


        try {

            PreparedStatement stmt = connection.prepareStatement(QUERY);
            ResultSet rs = stmt.executeQuery(QUERY);


            while (rs.next()) {
                System.out.println("O nome do jogo é: " + rs.getString("nomeJogo"));
                System.out.println("O id da empresa onde se encontra é: " +rs.getInt("idEmpresa")+"\n");

            }

        } catch (SQLException e) {

        }
        return "return";
    }

}

