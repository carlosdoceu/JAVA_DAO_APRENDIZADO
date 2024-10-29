package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) throws SQLException {
        String stringDeConexao = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        String stringUsuario = "root";
        String senha = "reicarlosfogo";

        Connection conexao = DriverManager.getConnection(stringDeConexao, stringUsuario, senha);

        System.out.println("Conexão estabelecida com sucesso!");
        conexao.close();
    }

}
