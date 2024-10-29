package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createDB {

     public static void main(String[] args) throws SQLException {
        // String stringDeConexao = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        // String stringUsuario = "root";
        // String senha = "reicarlosfogo";

        Connection conexao = FabricaConexao.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS CURSO_JAVA2");
        System.out.println("Database criada com sucesso!");
        conexao.close();
    }

}
