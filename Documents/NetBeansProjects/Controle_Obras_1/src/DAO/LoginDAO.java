
package DAO;

import DTO.LoginDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDAO {
    
    Connection conn;
    
    public ResultSet confirmacaoLogin(LoginDTO objlogindto) throws ClassNotFoundException{
        
        conn = new ConexaoBD().conectaBD();
        
        try {
            
            String sql = "SELECT *\n"
                    + "FROM projetoestoque.usuarios_estoque\n"
                    + "WHERE if_USER = ? AND senha = ?;";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objlogindto.getIf());
            
            pstm.setString(2, objlogindto.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "LoginDAO" + erro);
            
            return null;
        }
    }
}
