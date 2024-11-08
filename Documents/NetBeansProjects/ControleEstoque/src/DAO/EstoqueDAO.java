/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.EntradaDTO;
import DTO.EstoqueDTO;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstoqueDAO {
  Connection conn;
  PreparedStatement pstm;
  ResultSet rs;
  
  
  
  public void chamarProcedure() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        CallableStatement callableStatement = null;

        try {
            conn = new ConexaoBD().conectaBD();
            // Assume que você tem uma classe de conexão separada
            
            // Chama a procedure usando CallableStatement
            String sqlProcedure = "{CALL ATUALIZAESTOQUE}";
            callableStatement = (CallableStatement) conn.prepareCall(sqlProcedure);
            callableStatement.execute();
        } finally {
            // Fecha o CallableStatement e a conexão
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
                //esse código é para fazer o calculo automático do kw 
            }
        }
    }
  public List<EstoqueDTO> ConsultarEstoque(String codigo_item) throws ClassNotFoundException {
    List<EstoqueDTO> lista2 = new ArrayList<>();
    conn = new ConexaoBD().conectaBD();
    
    try {
        String con = "SELECT \n" +
            "    e.codigo_Item,\n" +
            "    e.NomeItem,\n" +
            "    e.quantidade,\n" +
            "    COALESCE(MAX(eb.Data_saida), MAX(em.Data_entrada)) AS data\n" +
            "FROM \n" +
            "    estoquemateriais_estoque e\n" +
            "LEFT JOIN \n" +
            "    execucaoestoque eb ON e.codigo_Item = eb.CodigoMaterial\n" +
            "LEFT JOIN \n" +
            "    entradamateriais_estoque em ON e.codigo_Item = em.codigo_Item\n";

        // Adiciona a cláusula WHERE se o codigo_item não for nulo ou vazio
        if (codigo_item != null && !codigo_item.trim().isEmpty()) {
            con += "WHERE e.codigo_Item = ? "; // Usar = para correspondência exata
        }

        // Adiciona o GROUP BY
        con += "GROUP BY \n" +
            "    e.codigo_Item, e.NomeItem, e.quantidade";
        
        System.out.println("Consulta SQL: " + con); // Verifique a consulta gerada
        
        pstm = conn.prepareStatement(con);
        
        int index = 1;
        if (codigo_item != null && !codigo_item.trim().isEmpty()) {
            pstm.setString(index++, codigo_item); // Usa = para correspondência exata
            System.out.println("Filtro aplicado: " + codigo_item); // Verifique o filtro
        }
        
        rs = pstm.executeQuery();
        
        while (rs.next()) {
            EstoqueDTO dto = new EstoqueDTO();
            dto.setCodigo_item(rs.getString("codigo_item"));
            dto.setNomeItem(rs.getString("NomeItem"));
            dto.setData(rs.getString("data")); // Verifique o nome da coluna
            dto.setQuantidade(rs.getString("quantidade")); // Verifique o nome da coluna
            
            lista2.add(dto);
        }

    } catch (Exception e) {
        e.printStackTrace(); // Para debugging
        JOptionPane.showMessageDialog(null, "Erro ao consultar estoque: " + e.getMessage());
    } finally {
        // Fechamento de recursos
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + ex.getMessage());
        }
    }

    return lista2;
}
}