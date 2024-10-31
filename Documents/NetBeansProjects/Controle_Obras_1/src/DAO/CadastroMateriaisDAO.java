/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DTO.MateriaisDTO;

public class CadastroMateriaisDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastroMateriais(MateriaisDTO objmateriaisDto) throws ClassNotFoundException {
        // SQL para inserir na tabela de materiais
        String sqlMateriais = "INSERT INTO projetoestoque.materiais_estoque (CódigoItem, NomeItem, UniMedida) VALUES (?, ?, ?)";
        
        // SQL para inserir na tabela de estoque geral
        String sqlEstoque = "INSERT INTO projetoestoque.estoquemateriais_estoque (codigo_Item, NomeItem) VALUES (?, ?)";
        
        conn = new ConexaoBD().conectaBD();
        
        try {
            // Inserção na tabela materiais_estoque
            pstm = conn.prepareStatement(sqlMateriais);
            pstm.setString(1, objmateriaisDto.getCódigoItem());
            pstm.setString(2, objmateriaisDto.getNomeItem());
            pstm.setString(3, objmateriaisDto.getUniMedida());
            pstm.executeUpdate();
            
            // Inserção na tabela estoque_geral
            pstm = conn.prepareStatement(sqlEstoque);
            pstm.setString(1, objmateriaisDto.getCódigoItem());
            pstm.setString(2, objmateriaisDto.getNomeItem());

            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso em ambas as tabelas!");
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro! Cadastro não realizado: " + erro);
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexões: " + e);
            }
        }
    }
}

