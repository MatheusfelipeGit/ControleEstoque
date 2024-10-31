/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
   
import DTO.EntradaDTO;
import DTO.SaidaDTO;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class EntradaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
     List<EntradaDTO> lista = new ArrayList<>();
    
    public void CadastrarEntrada (EntradaDTO entradadto) throws ClassNotFoundException, SQLException{
        
        String sql = "INSERT INTO projetoestoque.entradamateriais_estoque (codigo_item, NomeItem, Quantidade, QuemRecebeu, Data_entrada) values (?,?,?,?,?)";
        
        conn = new ConexaoBD().conectaBD();
        
        try{
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,entradadto.getCodigo_item());
        
        pstm.setString(2,entradadto.getNomeItem());
        
        pstm.setInt(3,entradadto.getQuantidade());
        
        pstm.setString(4,entradadto.getQuemRecebeu());
        
        pstm.setString(5,entradadto.getData_entrada());
        
        pstm.execute();
        
        }catch(SQLException e ){
        JOptionPane.showMessageDialog(null, "EntradaDao"+ e);
        
        }
        
    
    } 
    
    public List<EntradaDTO> ConsultarEntrada(String codigo_item, String QuemRecebeu, String Data) throws ClassNotFoundException {
    List<EntradaDTO> lista = new ArrayList<>();
    conn = new ConexaoBD().conectaBD();
    
    try {
        StringBuilder con = new StringBuilder("SELECT * FROM entradamateriais_estoque WHERE 1=1"); // Inicia a consulta

        // Adiciona condições de acordo com os parâmetros fornecidos
        if (codigo_item != null && !codigo_item.trim().isEmpty()) {
            con.append(" AND codigo_item LIKE ?");
        }
        
        if (QuemRecebeu != null && !QuemRecebeu.trim().isEmpty()) {
            con.append(" AND QuemRecebeu LIKE ?");
        }
        
        if (Data != null && !Data.trim().isEmpty()) {
            con.append(" AND Data_entrada LIKE ?");
        }

        pstm = conn.prepareStatement(con.toString());
        
        int index = 1;
        
        // Define os parâmetros
        if (codigo_item != null && !codigo_item.trim().isEmpty()) {
            pstm.setString(index++, "%" + codigo_item + "%");
        }

        if (QuemRecebeu != null && !QuemRecebeu.trim().isEmpty()) {
            pstm.setString(index++, "%" + QuemRecebeu + "%");
        }
        
        if (Data != null && !Data.trim().isEmpty()) {
            pstm.setString(index++, "%" + Data + "%");
        }
        
        rs = pstm.executeQuery();
        
        while (rs.next()) {
            EntradaDTO dto = new EntradaDTO();
            dto.setCodigo_item(rs.getString("codigo_item"));
            dto.setNomeItem(rs.getString("NomeItem"));
            dto.setData_entrada(rs.getString("Data_entrada"));
            dto.setQuantidade(rs.getInt("Quantidade"));
            dto.setQuemRecebeu(rs.getString("QuemRecebeu"));
            lista.add(dto);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "EntradaDAO: " + e);
    }
    
    return lista;
}
}
