package jdbc.desafios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import jdbc.FabricaConexao;

public class UpdatePessoa {
    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Id da pessoa:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite novo nome:");
        String nome = scanner.nextLine();

        
        Connection connection = FabricaConexao.getConexao();
        
        
        String sql = "UPDATE PESSOAS SET NOME = ? WHERE CODIGO = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(2, codigo);
        statement.setString(1,nome);

        statement.executeUpdate();

        
        
        


      
        statement.close();
        connection.close();

    }

}
