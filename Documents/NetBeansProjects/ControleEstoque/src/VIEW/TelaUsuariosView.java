
package VIEW;


import DTO.UsuariosDTO;
import DAO.UsuariosDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaUsuariosView extends javax.swing.JFrame {

    
    public TelaUsuariosView() {
        initComponents();
        setLocationRelativeTo(null);
        this.dispose();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ConsultaTelaUsuariosBtn = new javax.swing.JButton();
        cadastrarBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        BtnApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome ", "E-Mail"
            }
        ));
        jScrollPane1.setViewportView(TabelaUsuarios);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ConsultaTelaUsuariosBtn.setBackground(new java.awt.Color(102, 204, 255));
        ConsultaTelaUsuariosBtn.setText("Consultar");
        ConsultaTelaUsuariosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConsultaTelaUsuariosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaTelaUsuariosBtnActionPerformed(evt);
            }
        });

        cadastrarBtn.setBackground(new java.awt.Color(102, 204, 255));
        cadastrarBtn.setText("Cadastrar Novo Usuário");
        cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pref png1.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cadastrarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ConsultaTelaUsuariosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton3)
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarBtn)
                    .addComponent(ConsultaTelaUsuariosBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(BtnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            TelaMenuView telaMenu = new TelaMenuView();
            telaMenu.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ConsultaTelaUsuariosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaTelaUsuariosBtnActionPerformed
        try{
           listarValores();
        }catch(Exception erro){
            System.out.println("tela usuarios try/catch" + erro);
        }
    }//GEN-LAST:event_ConsultaTelaUsuariosBtnActionPerformed

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtnActionPerformed
       TelaCadastroUsuarioView telacad = new TelaCadastroUsuarioView();
       telacad.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_cadastrarBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         TelaMenuView menu = new TelaMenuView();
       menu.setVisible(true);
       
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int linhaSelecionada = TabelaUsuarios.getSelectedRow();
        if (linhaSelecionada != -1) {
            // Recuperar dados da linha selecionada

            String NomeCompleto = (String) TabelaUsuarios.getValueAt(linhaSelecionada, 0);
            String email = (String) TabelaUsuarios.getValueAt(linhaSelecionada, 1);
            

            // Obter novos valores

            String novaNome = JOptionPane.showInputDialog("Nome Completo:", NomeCompleto);
            String novoemail = JOptionPane.showInputDialog("E-mail:", email);
            

            // Chamar método para editar no banco de dados
            editarNoBanco( NomeCompleto,email, novaNome,novoemail);

            // Atualizar a linha na tabela

            TabelaUsuarios.setValueAt(novaNome != null ? novaNome : NomeCompleto, linhaSelecionada, 0);
            TabelaUsuarios.setValueAt(novoemail != null ? novoemail : email, linhaSelecionada, 1);
           
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BtnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApagarActionPerformed
        int linhaSelecionada = TabelaUsuarios.getSelectedRow();
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
            // Verifica o número de colunas
            int columnCount = TabelaUsuarios.getColumnCount();
            if (columnCount > 1) { // Verifica se a coluna 6 existe
                String NomeCompleto = (String) TabelaUsuarios.getValueAt(linhaSelecionada, 0); // N Medicao
                String email = (String) TabelaUsuarios.getValueAt(linhaSelecionada, 1); // N Medicao

                // Remover a linha do modelo
                ((DefaultTableModel) TabelaUsuarios.getModel()).removeRow(linhaSelecionada);

                // Chamar método para remover do banco de dados
                removerDoBanco(NomeCompleto,email);
            } else {
                JOptionPane.showMessageDialog(null, "A tabela não contém colunas suficientes.");
            }
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

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuariosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnApagar;
    private javax.swing.JButton ConsultaTelaUsuariosBtn;
    private javax.swing.JTable TabelaUsuarios;
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void listarValores(){
    
    try{
        
        UsuariosDAO usuariosDao = new UsuariosDAO();
        DefaultTableModel model = (DefaultTableModel) TabelaUsuarios.getModel();
            model.setNumRows(0);
            
            String NomeCompleto = null;
            String email = null;
      
            List<UsuariosDTO> lista = usuariosDao.consultarUsuarios(NomeCompleto, email);

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                    lista.get(i).getNomeCompleto(),
                    lista.get(i).getEmail()
                    ,});
            }
}catch(Exception erro){
    JOptionPane.showMessageDialog(null, "telaUsuarios" + erro);
}
}




private void removerDoBanco(String NomeCompleto, String email) {
        // Aqui você deve implementar a lógica para remover o registro do banco de dados
        Connection conn = null; // Obtenha sua conexão aqui
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoestoque?serverTimezone=America/Sao_Paulo", "root", "1234");
             System.out.println("Conexão estabelecida com sucesso!");// Ajuste conforme necessário
            
            
           String sql = "DELETE FROM projetoestoque.usuarios_estoque WHERE NomeCompleto = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, NomeCompleto);
           
            
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
private void editarNoBanco(String NomeCompleto, String email, String novaNome, String novoemail) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoestoque?serverTimezone=America/Sao_Paulo", "root", "1234");
        
        // Começa a construção da SQL
        StringBuilder sql = new StringBuilder("UPDATE projetoestoque.usuarios_estoque SET ");
        List<String> updates = new ArrayList<>();

        // Adiciona apenas os campos que não são nulos
        if (NomeCompleto != null) updates.add("NomeCompleto = ?");
        if (email != null) updates.add("email = ?");
        
        
        // Verifica se algum campo foi passado para atualização
        if (updates.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum campo para atualizar.");
            return;
        }

        // Adiciona os updates à SQL
        sql.append(String.join(", ", updates));
        sql.append(" WHERE NomeCompleto = ?"); // Condições para identificar o registro

        stmt = conn.prepareStatement(sql.toString());

        // Preenche os parâmetros
        int index = 1;
        
        if (novaNome != null) stmt.setString(index++, novaNome);
        if (novoemail != null) stmt.setString(index++, novoemail);
        
        
        // Adiciona o parâmetro de filtro
        stmt.setString(index++, NomeCompleto); // Use o código antigo para a condição WHERE
        
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
}
