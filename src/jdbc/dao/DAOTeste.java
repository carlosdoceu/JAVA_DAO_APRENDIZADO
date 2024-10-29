package jdbc.dao;

public class DAOTeste {
    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO PESSOAS (NOME) VALUES (?)";

        System.out.println(dao.incluir(sql, "Joao Silva"));
        System.out.println(dao.incluir(sql, "Ana Julia"));
        System.out.println(dao.incluir(sql, "Djavam Silva"));
        System.out.println(dao.incluir(sql, "Maria Silva"));

        dao.close();
    }

}
