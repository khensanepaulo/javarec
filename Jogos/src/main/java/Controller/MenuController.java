package Controller;

import DAO.*;
import Model.EmpresaModel;

import java.util.List;

public class MenuController {
    public void Selecao(String op)
    {
        if (op.equals("1"))
        {
            CadastrarEmpresaController();

        }

        if (op.equals("2"))
        {
            CadastrarCategoriaController();

        }

        if (op.equals("3"))
        {
            CadastrarJogoController();

        }

        if (op.equals("4"))
        {
            EditarCategoriaController();

        }

        if (op.equals("5"))
        {
            PesquisarJogoController();

        }

        if (op.equals("6"))
        {
            ListarJogosDeUmaEmpresaController();

        }

        if (op.equals("7"))
        {
            ListarJogosDoCategoriaController();

        }
        if (op.equals("8"))
        {
            ListarEmpresasController();

        }

    }
    public List<EmpresaModel> ListarEmpresasController(){
        ListarEmpresasDAO listarEmpresasDAO = new ListarEmpresasDAO();
        List<EmpresaModel> empresas = listarEmpresasDAO.ListarEmpresas();
        return listarEmpresasDAO.ListarEmpresas();

    }

    public String CadastrarEmpresaController()
    {
        CadastroEmpresaDAO cadastroEmpresaDAO = new CadastroEmpresaDAO();
        cadastroEmpresaDAO.criarTabelaDeEmpresas();
        return cadastroEmpresaDAO.cadastrarEmpresa();
    }

    public String CadastrarCategoriaController()
    {
        CadastroCategoriaDAO cadastroCategoriaDAO = new CadastroCategoriaDAO();
        cadastroCategoriaDAO.criarTabelaDeCategorias();
        return cadastroCategoriaDAO.cadastrarCategorias();
    }

    public String CadastrarJogoController()
    {
        CadastroJogoDAO cadastroJogoDAO = new CadastroJogoDAO();
        cadastroJogoDAO.criarTabelaDeJogos();
        return cadastroJogoDAO.cadastrarJogo();

    }
    public String EditarCategoriaController()
    {
        EditarCategoriaDAO editarCategoriaDAO = new EditarCategoriaDAO();
        return editarCategoriaDAO.editarTabela();
    }
    public String PesquisarJogoController()
    {
        PesquisarJogoDAO pesquisarJogoDAO = new PesquisarJogoDAO();
        return pesquisarJogoDAO.ProcurarJogoPorID();

    }
    public String ListarJogosDeUmaEmpresaController()
    {
        ListarJogosDeUmaEmpresaDAO listarJogosDeUmaEmpresaDAO = new ListarJogosDeUmaEmpresaDAO();
        return listarJogosDeUmaEmpresaDAO.ListarJogosDaEmpresa();
    }
    public String ListarJogosDoCategoriaController()
    {
        ListarJogosCategoriaDAO listarJogosCategoriaDAO = new ListarJogosCategoriaDAO();
        return listarJogosCategoriaDAO.ListarJogosDoCategoria();

    }
}

