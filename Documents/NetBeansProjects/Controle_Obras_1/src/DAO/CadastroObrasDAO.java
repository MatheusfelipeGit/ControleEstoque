/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ObrasDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

public class CadastroObrasDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ObrasDTO> listarDados = new ArrayList<>();
    ArrayList<ObrasDTO> listarMateriais = new ArrayList<>();
    
    
    public void CadastrarObras(ObrasDTO obrasDto) throws ClassNotFoundException {
        String sql = "INSERT INTO projetoestoque.obras_estoque (LocalObra, Tipo, DataCad) values (?, ?, ?)";
        conn = new ConexaoBD().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, obrasDto.getLocalObra());
            pstm.setString(2, obrasDto.getTipo());
            pstm.setString(3, obrasDto.getDataCad());
            
            pstm.execute();
            }
    catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "ObrasDao" + erro);
            }
        }

    public ResultSet listarDados() throws ClassNotFoundException{
        conn = new ConexaoBD().conectaBD();
        String sql = "SELECT * FROM Logradouros";
        
    try{
        
        pstm = conn.prepareStatement(sql);
        return pstm.executeQuery();
    
    }
    
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "resultadoCombobox" + e);
    }
    
    return null;
    
    }
    
    
    public ResultSet listarMateriais() throws ClassNotFoundException{
        conn = new ConexaoBD().conectaBD();
        String sql = "SELECT Nome FROM materiais_estoque";
        
    try{
        
        pstm = conn.prepareStatement(sql);
        return pstm.executeQuery();
    
    }
    
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "resultadoCombobox" + e);
    }
    
    return null;
    
    }
    
    
}
