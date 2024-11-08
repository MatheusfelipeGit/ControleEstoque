
package DAO;

import DTO.SaidaDTO;
import java.io.FileOutputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

public class SaidaDAO {
   Connection conn;
   PreparedStatement pstm;
   ResultSet rs;
   List<SaidaDTO> lista = new ArrayList<>();
   
   
   public void CadastrarExecucao (SaidaDTO execucaodeServicoDTO) throws ClassNotFoundException {
       // Consulta para verificar a existência da OS na tabela OBRAS
        String verificaOSsql = "SELECT OS FROM projetoestoque.obras_estoque WHERE OS = ?";

      
        try {
            conn = new ConexaoBD().conectaBD();

            // Verificar se a OS existe na tabela OBRAS
            pstm = conn.prepareStatement(verificaOSsql);
            pstm.setString(1, execucaodeServicoDTO.getOS());
            rs = pstm.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "OS não encontrada na tabela OBRAS.");
                return; // Se a OS não existe, não faz mais nada
            }
                 else {
                // Inserir novo registro na tabela EXECUCAOOBRAS
                String insertsql = "INSERT INTO projetoestoque.execucaoestoque (OS, NomeMaterial, CodigoMaterial, Quantidade, Data_saida, Requisitante, Responsavel, Local) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                pstm = conn.prepareStatement(insertsql);
                pstm.setString(1, execucaodeServicoDTO.getOS());
                pstm.setString(2, execucaodeServicoDTO.getNomeMaterial());
                pstm.setString(3, execucaodeServicoDTO.getCodigoMaterial());
                pstm.setString(4, execucaodeServicoDTO.getQuantidade());
                pstm.setString(5, execucaodeServicoDTO.getData_saida());
                pstm.setString(6, execucaodeServicoDTO.getRequisitante());
                pstm.setString(7, execucaodeServicoDTO.getResponsavel());
                pstm.setString(8, execucaodeServicoDTO.getLocal());

                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastro Realizado Com Sucesso!!!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExecucaoObras: " + e.getMessage());
        } finally {
            // Fechar conexões e recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
    
    public void exportarParaPlanilha(List<SaidaDTO> listar, String filePath) {
    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
        headerRow.createCell(0).setCellValue("OS");
        headerRow.createCell(1).setCellValue("Nome Item");
        headerRow.createCell(2).setCellValue("Código Item");
        headerRow.createCell(3).setCellValue("Quantidade");
        headerRow.createCell(4).setCellValue("Data_saida");
        headerRow.createCell(5).setCellValue("Requisitante");
        headerRow.createCell(6).setCellValue("Responsavel");
        headerRow.createCell(7).setCellValue("Local");


        // Preenche os dados na planilha a partir da lista de DTOs
    for (SaidaDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);

                dataRow.createCell(0).setCellValue(dto.getOS() );
                dataRow.createCell(1).setCellValue(dto.getNomeMaterial() );
                dataRow.createCell(2).setCellValue(dto.getCodigoMaterial() );
                dataRow.createCell(3).setCellValue(dto.getQuantidade() );
                dataRow.createCell(4).setCellValue(dto.getData_saida());
                dataRow.createCell(5).setCellValue(dto.getRequisitante());
                dataRow.createCell(6).setCellValue(dto.getResponsavel());
                dataRow.createCell(7).setCellValue(dto.getLocal());

            }

        // Mensagem que avisa onde a planilha está/ Salva a mesma
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
            System.out.println("Planilha exportada com sucesso para: " + filePath);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  public List<SaidaDTO> ListarMedicoes(String Endereco,String OS, String Requisitante, String Responsavel) throws ClassNotFoundException {
    List<SaidaDTO> lista = new ArrayList<>();
    conn = new ConexaoBD().conectaBD();
    
      try {
        String sql = "SELECT o.LocalObra, o.Tipo, ex.* FROM projetoestoque.execucaoestoque ex "
                   + "INNER JOIN projetoestoque.obras_estoque o ON ex.OS = o.OS";
        
        boolean hasWhereClause = false;
        
        if (Endereco != null && !Endereco.trim().isEmpty()) {
            sql += " WHERE o.LocalObra LIKE ?";
            hasWhereClause = true;
        }
        
        if (OS != null && !OS.trim().isEmpty()) {
            sql += (hasWhereClause ? " AND" : " WHERE") + " o.OS LIKE ?";
            hasWhereClause = true;
        }
        
        if (Requisitante != null && !Requisitante.trim().isEmpty()) {
            sql += (hasWhereClause ? " AND" : " WHERE") + " ex.Requisitante LIKE ?";
            hasWhereClause = true;
        }
        
        if (Responsavel != null && !Responsavel.trim().isEmpty()) {
            sql += (hasWhereClause ? " AND" : " WHERE") + " ex.Responsavel LIKE ?";
        }
        
        pstm = conn.prepareStatement(sql);
        
        int index = 1;
        if (Endereco != null && !Endereco.trim().isEmpty()) {
            pstm.setString(index++, "%" + Endereco + "%");
        }
        
        if (OS != null && !OS.trim().isEmpty()) {
            pstm.setString(index++, "%" + OS + "%");
        }
        
        if (Requisitante != null && !Requisitante.trim().isEmpty()) {
            pstm.setString(index++, "%" + Requisitante + "%");
        }
        
        if (Responsavel != null && !Responsavel.trim().isEmpty()) {
            pstm.setString(index++, "%" + Responsavel + "%");
        }
        
        rs = pstm.executeQuery();
        
        while (rs.next()) {
            SaidaDTO dto = new SaidaDTO();
            dto.setOS(rs.getString("OS"));
            dto.setNomeMaterial(rs.getString("NomeMaterial"));
            dto.setCodigoMaterial(rs.getString("CodigoMaterial"));
            dto.setQuantidade(rs.getString("Quantidade"));
            dto.setData_saida(rs.getString("Data_saida"));
            dto.setRequisitante(rs.getString("Requisitante"));
            dto.setResponsavel(rs.getString("Responsavel"));
            dto.setLocal(rs.getString("Local"));
            
            lista.add(dto);
        }
          
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar dados: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
        }
    }
    return lista;
}

    public void exportarParaPlanilha(List<SaidaDTO> listaConsultas, Workbook workbook) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
