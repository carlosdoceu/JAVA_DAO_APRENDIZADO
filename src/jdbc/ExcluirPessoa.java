package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
    

    public static void main(String[] args) throws SQLException {
        

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Id da pessoa:");
        int codigo = scanner.nextInt();

        Connection connection = FabricaConexao.getConexao();
        String sql = "DELETE FROM PESSOAS WHERE CODIGO = ?";


        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, codigo);
         if (statement.executeUpdate() > 0) {
             System.out.println("Registro excluido com sucesso!");
         } else {   
             System.out.println("Registro não excluido!");
         }
    }



}
