package DAO;

import Factory.ConnectionFactory;
import Model.JogoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroJogoDAO {

    private Connection connection;

    public CadastroJogoDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }






    public void criarTabelaDeJogos()
    {
        String sql = "CREATE TABLE IF NOT EXISTS `prova`.`jogos` (\n" +
                "  `idJogos` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `idCategoria` INT NULL,\n" +
                "  `idEmpresa` INT NULL,\n" +
                "  `nomeJogo` VARCHAR(255) NULL,\n" +
                "  PRIMARY KEY (`idJogos`),\n" +
                "  INDEX `idCategoria_idx` (`idCategoria` ASC) VISIBLE,\n" +
                "  INDEX `idEmpresa_idx` (`idEmpresa` ASC) VISIBLE,\n" +
                "  CONSTRAINT `idCategoria`\n" +
                "    FOREIGN KEY (`idCategoria`)\n" +
                "    REFERENCES `prova`.`categorias` (`IdCategoria`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `idEmpresa`\n" +
                "    FOREIGN KEY (`idEmpresa`)\n" +
                "    REFERENCES `prova`.`empresas` (`IdEmpresa`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE);";

        try {


            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String cadastrarJogo() {

        Scanner sc1 = new Scanner(System.in);
        JogoModel jogoModel = new JogoModel();


        System.out.println("Insira o nome do jogo que quer adicionar a tabela");
        jogoModel.setNomeJogo(sc1.nextLine());
        System.out.println("Insira o ID do gênero ao qual o jogo pertence");
        jogoModel.setIdCategoria(sc1.nextInt());
        System.out.println("Insira o ID da empresa ao qual o jogo pertence");
        jogoModel.setIdEmpresa(sc1.nextInt());



        String temp = "";
        String QUERY = "INSERT INTO Jogos(nomeJogo,idCategoria,idEmpresa) VALUES (?,?,?)";

        try{

            PreparedStatement stmt = connection.prepareStatement(QUERY);
            stmt.setString(1, jogoModel.getNomeJogo());
            stmt.setInt(2, jogoModel.getIdCategoria());
            stmt.setInt(3, jogoModel.getIdEmpresa());
            stmt.execute();

            System.out.println("Cadastro feito com sucesso");
            String mensagem = String.format("o jogo '%s' foi adicionado a tabela",jogoModel.getNomeJogo());
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

