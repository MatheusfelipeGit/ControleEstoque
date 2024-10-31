/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuariosDTO;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import java.sql.SQLException;


public class UsuariosDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    List<UsuariosDTO> lista = new ArrayList<>();
    
    public List<UsuariosDTO> consultarUsuarios(String NomeCompleto, String email) throws ClassNotFoundException{
    
    conn = new ConexaoBD().conectaBD();
    
    try{
        
        String sql = "SELECT * FROM projetoestoque.usuarios_estoque";
        
        pstm = conn.prepareStatement(sql);
        
        rs = pstm.executeQuery();
        
        while(rs.next()){
        
        UsuariosDTO usuariosDto = new UsuariosDTO();
        
        usuariosDto.setNomeCompleto(rs.getString("NomeCompleto"));
        usuariosDto.setEmail(rs.getString("email"));
        
        lista.add(usuariosDto);
    }
    } catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "UsuariosDAO" + erro);
        
    } return lista;
} 
}
