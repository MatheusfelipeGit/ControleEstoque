package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    private Connection conn;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/projetoestoque?serverTimezone=America/Sao_Paulo"; // Adicionado serverTimezone
    private String user = "root";
    private String password = "1234";
    
    public Connection conectaBD() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException erro) {
            System.out.println(erro);
            return null;
        }
    }
}
