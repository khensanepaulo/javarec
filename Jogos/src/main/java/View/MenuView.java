package View;

import Controller.MenuController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuView {
    static MenuController controller = new MenuController();
    static BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    public static void MainMenuView() throws IOException {

        String option = "";

        do {
            System.out.println("1. Cadastrar Empresa");
            System.out.println("2. Cadastrar Gênero");
            System.out.println("3. Cadastrar Jogo");
            System.out.println("4. Editar Gênero");
            System.out.println("5. Encontrar Jogo Pelo Seu ID");
            System.out.println("6. Listar Todos Os Jogos De Uma Empresa Específica");
            System.out.println("7. Listar Todos Os Jogos De Determinado Gênero");
            System.out.println("8. Listar Todas as Empresas");

            option = obj.readLine();
            System.out.println("\n");

            switch (option) {

                case "1":
                    controller.Selecao(option);
                    break;

                case "2":
                    controller.Selecao(option);
                    break;

                case "3":
                    controller.Selecao(option);
                    break;

                case "4":
                    controller.Selecao(option);
                    break;

                case "5":
                    controller.Selecao(option);
                    break;

                case "6":
                    controller.Selecao(option);
                    break;

                case "7":
                    controller.Selecao(option);
                    break;

                case "8":
                    controller.Selecao(option);
                    break;



                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (!option.equals("9"));
    }



}


