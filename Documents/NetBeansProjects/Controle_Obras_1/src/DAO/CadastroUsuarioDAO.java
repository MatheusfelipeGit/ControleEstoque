/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.UsuariosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroUsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastroUsuario(UsuariosDTO objusuariosDto) throws ClassNotFoundException {
        String sql = "insert into projetoestoque.usuarios_estoque (NomeCompleto, If_USER, email, senha) values (?, ?, ?, ?)";
        
        conn = new ConexaoBD().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objusuariosDto.getNomeCompleto());
            pstm.setString(2, objusuariosDto.getIf_USER());
            pstm.setString(3, objusuariosDto.getEmail());
            pstm.setString(4, objusuariosDto.getSenha());
            
            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO!!!");
            
        
                    
        } catch(SQLException erro) {
           JOptionPane.showMessageDialog(null, "Erro! Cadastro não realizado, confira se todos os campos foram preenchidos");
        }
        
    }
    
    
}
