package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.FabricaConexao;

//DAO simples
public class DAO {

    private Connection connection;

    public int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement statement = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(statement, atributos);
            if (statement.executeUpdate() > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
            return -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void adicionarAtributos(PreparedStatement statement, Object[] atributos) throws SQLException {
        int indice = 1;
        for (Object atributo : atributos) {
            if (atributo instanceof String) {
                statement.setString(indice, (String) atributo);
            } else if (atributo instanceof Integer) {
                statement.setInt(indice, (Integer) atributo);
            }
            indice++;
        }
    }

    private Connection getConexao() {
        try {

            if (connection != null && !connection.isClosed()) {
                return connection;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection = FabricaConexao.getConexao();
        return connection;
    }

    public void close() {
        try {
            getConexao().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
