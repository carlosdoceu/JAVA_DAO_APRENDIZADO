package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args)  throws SQLException{
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        // String codigo = scanner.nextLine();

        Connection connection = FabricaConexao.getConexao();

        String sql = "INSERT INTO PESSOAS (CODIGO, NOME) VALUES (?,?)";

        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1000);
        statement.setString(2, nome);
        statement.executeUpdate();
        System.out.println("Registro inserido com sucesso!");


    }
}
