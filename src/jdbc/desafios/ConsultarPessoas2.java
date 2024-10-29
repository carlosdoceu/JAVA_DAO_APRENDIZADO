package jdbc.desafios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdbc.FabricaConexao;
import jdbc.Pessoa;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("item a pesquisar:");
        String item = scanner.nextLine();

        Connection connection = FabricaConexao.getConexao();

        String sql = "SELECT * FROM PESSOAS WHERE NOME LIKE ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + item + "%");
        ResultSet resultSet = statement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultSet.next()) {
            int codigo = resultSet.getInt("CODIGO");
            String nome = resultSet.getString("NOME");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + " - " + p.getNome());
        }

        statement.close();
        connection.close();

    }

}
