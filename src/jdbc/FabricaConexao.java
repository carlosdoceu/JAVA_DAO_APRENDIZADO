package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    public static Connection getConexao() {
        try {
            Properties properties = getProperties();

            final String url = properties.getProperty("banco.url");
            final String user = properties.getProperty("banco.user");
            final String senha = properties.getProperty("banco.senha");

            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String caminho = "/resources/application.properties";
        properties.load(FabricaConexao.class.getResourceAsStream(caminho));


       

        return properties;
    }

}
