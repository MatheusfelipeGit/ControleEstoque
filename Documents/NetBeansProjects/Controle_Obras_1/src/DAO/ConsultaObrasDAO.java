
package DAO;

import DTO.ObrasDTO;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ConsultaObrasDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    List<ObrasDTO> lista = new ArrayList<>();
    
    public List<ObrasDTO> consultarObras (String OS) throws ClassNotFoundException {
        
        conn = new ConexaoBD().conectaBD();
        
        try{
            
            String sql = "SELECT * FROM projetoestoque.obras_estoque";
            
             if (OS != null && !OS.trim().isEmpty()) {
            sql += " WHERE OS LIKE ?"; // Usa AND para a condição inicial
        }
            
            pstm = conn.prepareStatement(sql);
            
            int index = 1;
        // Adiciona o parâmetro se OS não estiver vazio
         if (!OS.isEmpty()) {
        pstm.setString(index++, "%" + OS + "%");
        }
            
            rs = pstm.executeQuery();
            
            while(rs.next()){
                
            ObrasDTO obrasdto = new ObrasDTO();
            
            obrasdto.setOS(rs.getString("OS"));
            obrasdto.setEndereco(rs.getString("Endereço"));
            obrasdto.setLocalObra(rs.getString("LocalObra"));
            obrasdto.setTipo(rs.getString("Tipo"));
            obrasdto.setDataCad(rs.getString("DataCad"));
            
            
            lista.add(obrasdto);
               
            }
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERRO AO RETORNAR DADOS!" + e);
        
        }
        return lista;
    }
    public void exportarParaPlanilha(List<ObrasDTO> listar, String filePath) {
    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Dados"); // Cria uma nova planilha com o nome "Dados"

        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);

        // Define o cabeçalho das colunas da planilha
        headerRow.createCell(0).setCellValue("OS");
        headerRow.createCell(1).setCellValue("END");
        headerRow.createCell(2).setCellValue("Local");
        headerRow.createCell(3).setCellValue("Tipo");
        headerRow.createCell(4).setCellValue("Data");
       
        // Preenche os dados na planilha a partir da lista de DTOs
    for (ObrasDTO dto : listar) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(dto.getOS() );
                dataRow.createCell(1).setCellValue(dto.getEndereco());
                dataRow.createCell(2).setCellValue(dto.getLocalObra() );
                dataRow.createCell(3).setCellValue(dto.getTipo() );
                dataRow.createCell(4).setCellValue(dto.getDataCad() );
                
                
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
}
