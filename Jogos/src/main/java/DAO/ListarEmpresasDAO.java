package DAO;

import Factory.ConnectionFactory;
import Model.EmpresaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mysql.cj.util.SaslPrep.StringType.QUERY;

public class ListarEmpresasDAO {
    Connection connection;



    public List<EmpresaModel> ListarEmpresas() {

        {


            String sql = "SELECT * FROM empresas";

            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultSet = stmt.executeQuery();

                List<EmpresaModel> empresas = new ArrayList<>();
                EmpresaModel empresa;

                while (resultSet.next()) {
                    empresa = new EmpresaModel();
                    empresa.setIdEmpresa(resultSet.getInt("idEmpresa"));
                    empresa.setNomeEmpresa(resultSet.getString("nome"));

                    ListarEmpresasDAO tpDAO = new ListarEmpresasDAO();


                    empresas.add(empresa);
                }

                return empresas;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



