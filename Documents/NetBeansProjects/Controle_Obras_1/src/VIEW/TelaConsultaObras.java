/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ConsultaObrasDAO;
import DTO.ObrasDTO;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jateixeira
 */
public class TelaConsultaObras extends javax.swing.JFrame {

    /**
     * Creates new form TelaConsultaObras
     */
    public TelaConsultaObras() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        BtnApagar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OS", "Endereço", "Local", "Tipo", "Data"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("CONSULTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VOLTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("OS:");

        jButton3.setText("EXPORTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lapis-icon.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        BtnApagar.setBackground(new java.awt.Color(255, 0, 0));
        BtnApagar.setForeground(new java.awt.Color(255, 255, 255));
        BtnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/54324.png"))); // NOI18N
        BtnApagar.setBorder(null);
        BtnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApagarActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pref png1.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(214, 214, 214)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(BtnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton4)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarObras();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          int linhaSelecionada = jTable1.getSelectedRow();
    if (linhaSelecionada != -1) {
        // Recuperar dados da linha selecionada
        String OS = (String) jTable1.getValueAt(linhaSelecionada, 0);
        String Endereço = (String) jTable1.getValueAt(linhaSelecionada, 1);
        String LocalObra = (String) jTable1.getValueAt(linhaSelecionada, 2);
        String Tipo = (String) jTable1.getValueAt(linhaSelecionada, 3);
        String DataCad = (String) jTable1.getValueAt(linhaSelecionada, 4);

        // Obter novos valores
        String novaOS = JOptionPane.showInputDialog("OS:", OS);
        String novoEndereço = JOptionPane.showInputDialog("Endereço:", Endereço);
        String novaLocalObra = JOptionPane.showInputDialog("Local Obra:", LocalObra);
        String novaTipo = JOptionPane.showInputDialog("Tipo:", Tipo);
        String novaDataCad = JOptionPane.showInputDialog("Data:", DataCad);

        // Chamar método para editar no banco de dados
        editarNoBanco(OS, novaOS, novoEndereço, novaLocalObra, novaTipo, novaDataCad); // Corrigido

        // Atualizar a linha na tabela
        jTable1.setValueAt(novaOS != null ? novaOS : OS, linhaSelecionada, 0);
        jTable1.setValueAt(novoEndereço != null ? novoEndereço : Endereço, linhaSelecionada, 1);
        jTable1.setValueAt(novaLocalObra != null ? novaLocalObra : LocalObra, linhaSelecionada, 2);
        jTable1.setValueAt(novaTipo != null ? novaTipo : Tipo, linhaSelecionada, 3);
        jTable1.setValueAt(novaDataCad != null ? novaDataCad : DataCad, linhaSelecionada, 4);
    } else {
        JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
    }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void BtnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApagarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada != -1) {
    int resposta = JOptionPane.showConfirmDialog(
        null,
        "Tem certeza que deseja apagar este item?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (resposta == JOptionPane.YES_OPTION) {
        try {
            // Acessando as colunas corretas
            String OS = (String) jTable1.getValueAt(linhaSelecionada, 0); // N Medicao

            // Remover a linha do modelo
            ((DefaultTableModel) jTable1.getModel()).removeRow(linhaSelecionada);

            // Chamar método para remover do banco de dados
            removerDoBanco(OS);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os dados da tabela. Verifique os índices.");
            ex.printStackTrace();
        }
    } else {
        // O usuário escolheu não apagar
        JOptionPane.showMessageDialog(null, "Operação cancelada.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Selecione uma linha para apagar.");
}

    }//GEN-LAST:event_BtnApagarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            exportarParaPlanilha(jTextField1.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       TelaCadastroDemandas cadobra = new TelaCadastroDemandas();
       cadobra.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       TelaMenuView menu = new TelaMenuView();
       menu.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaObras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnApagar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private void listarObras(){
try{
        
        ConsultaObrasDAO consultaobras = new ConsultaObrasDAO();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setNumRows(0);
                
                String OS = jTextField1.getText();
                
                List<ObrasDTO> lista = consultaobras.consultarObras(OS);
                
                for (int i = 0; i < lista.size(); i++) {
                    
                    model.addRow(new Object[] {
                        lista.get(i).getOS(),
                        lista.get(i).getEndereco(),
                        lista.get(i).getLocalObra(),
                        lista.get(i).getTipo(),
                        lista.get(i).getDataCad()
                        ,});
                }
                } catch(Exception erro){
                    JOptionPane.showMessageDialog(null, "TelaMateriais" + erro);
    }


}
private void editarNoBanco(String OS, String novoOS, String Endereço, String LocalObra, String Tipo, String DataCad) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoestoque?serverTimezone=America/Sao_Paulo", "root", "1234");
        
        StringBuilder sql = new StringBuilder("UPDATE obras_estoque SET ");
        List<String> updates = new ArrayList<>();

        // Adiciona apenas os campos que não são nulos
        if (novoOS != null) updates.add("OS = ?");
        if (Endereço != null) updates.add("Endereço = ?");
        if (LocalObra != null) updates.add("LocalObra = ?");
        if (Tipo != null) updates.add("Tipo = ?");
        if (DataCad != null) updates.add("DataCad = ?");

        if (updates.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum campo para atualizar.");
            return;
        }

        sql.append(String.join(", ", updates));
        sql.append(" WHERE OS = ?"); // Condição para identificar o registro

        stmt = conn.prepareStatement(sql.toString());

        int index = 1;

        if (novoOS != null) stmt.setString(index++, novoOS);
        if (Endereço != null) stmt.setString(index++, Endereço);
        if (LocalObra != null) stmt.setString(index++, LocalObra);
        if (Tipo != null) stmt.setString(index++, Tipo);
        if (DataCad != null) stmt.setString(index++, DataCad);

        // Adiciona o parâmetro de filtro
        stmt.setString(index++, OS); // Use o OS original para a condição WHERE

        // Execute a atualização
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Registro editado com sucesso!");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao editar registro no banco.");
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


private void removerDoBanco(String OS) {
        // Aqui você deve implementar a lógica para remover o registro do banco de dados
        Connection conn = null; // Obtenha sua conexão aqui
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoestoque?serverTimezone=America/Sao_Paulo", "root", "1234");
             System.out.println("Conexão estabelecida com sucesso!");// Ajuste conforme necessário
            
            
           String sql = "DELETE FROM obras_estoque WHERE OS = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, OS);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao apagar registro do banco.");
        } finally {
            // Feche a conexão e o statement, se necessário
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
private void exportarParaPlanilha(String OS) throws ClassNotFoundException {
    // Caminho da pasta onde as planilhas serão armazenadas
    String pasta = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Planilhas Obras";

    // Criar a pasta, se não existir
    File diretorio = new File(pasta);
    if (!diretorio.exists()) {
        boolean criada = diretorio.mkdir();
        if (!criada) {
            System.out.println("Erro ao criar a pasta: " + pasta);
            return;
        }
    }

    // Nome do arquivo
    String filePath = pasta + File.separator + "obras.xlsx";

    // Obter dados do DAO
    ConsultaObrasDAO dao = new ConsultaObrasDAO();
    List<ObrasDTO> listaConsultas = dao.consultarObras(OS);

    // Chamar o método do DAO para exportar os dados
    try {
        dao.exportarParaPlanilha(listaConsultas, filePath);
        System.out.println("Planilha exportada com sucesso: " + filePath);
    } catch (Exception e) {
        System.out.println("Erro ao exportar a planilha: " + e.getMessage());
        e.printStackTrace();
    }
}


}