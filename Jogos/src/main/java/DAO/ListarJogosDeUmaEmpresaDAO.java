package DAO;

import Factory.ConnectionFactory;

import java.sql.*;
import java.util.Scanner;

public class ListarJogosDeUmaEmpresaDAO {

    private Connection connection;

    public ListarJogosDeUmaEmpresaDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }

    public String ListarJogosDaEmpresa() {

        int idEncontrado = 0;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Digite o id da empresa desejada");
        int nome = Integer.parseInt(sc1.nextLine());
        String QUERY = String.format("SELECT * FROM empresas WHERE idEmpresa = '%d' ", nome);


        try {

            PreparedStatement stmt = connection.prepareStatement(QUERY);
            ResultSet rs = stmt.executeQuery(QUERY);


            while (rs.next()) {
                idEncontrado = rs.getInt("idEmpresa");

            }

        } catch (SQLException e) {

        }


        String QUERY2 = String.format("SELECT * FROM jogos WHERE idEmpresa = %d", idEncontrado);


        try {

            PreparedStatement stmt = connection.prepareStatement(QUERY2);
            ResultSet rs = stmt.executeQuery(QUERY2);


            while (rs.next()) {
                System.out.println("O nome do jogo é: " + rs.getString("nomejogo"));
                System.out.println("O id do seu gênero é: " + rs.getInt("idCategoria") + "\n");


            }

        } catch (SQLException e) {

        }
        return "return";
    }



}

