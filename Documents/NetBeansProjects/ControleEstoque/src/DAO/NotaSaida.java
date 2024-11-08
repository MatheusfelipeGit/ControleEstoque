/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class NotaSaida implements ActionListener {
    
    
    private JTextField DataTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JComboBox NomeTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JTextField QuantidadeTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    private JComboBox RequerenteTxt; //criei um txt com esse nome e dei esse nome ao txt da tela de relatorio
    

    public NotaSaida(JTextField DataTxt, JComboBox NomeTxt, JTextField QuantidadeTxt, JComboBox RequerenteTxt) {

        this.DataTxt = DataTxt;
        this.NomeTxt = NomeTxt;
        this.QuantidadeTxt = QuantidadeTxt;
        this.RequerenteTxt = RequerenteTxt;


        // aqui ele declara que tudo que tem dentro dele é dele 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            geraRelatorio(); // esse é meu método, onde que chamo ele para gerar
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void geraRelatorio() throws ClassNotFoundException {
        String erro = "";

        String Data = DataTxt.getText();
        String NomeMaterial = (String) NomeTxt.getSelectedItem();
        String Quantidade = QuantidadeTxt.getText();
        String Requisitante = (String )RequerenteTxt.getSelectedItem();


        String jasper = "C:\\Users\\jateixeira\\Desktop\\teste faturas\\edição faturas\\ControleSaida\\ModeloNota.jasper"; //aqui é onde está o projeto que querem gerar

        HashMap<String, Object> param = new HashMap<String, Object>();

        param.put("Data", Data);
        param.put("NomeMaterial", NomeMaterial);
        param.put("Quantidade", Quantidade);
        param.put("Requisitante", Requisitante);

        byte[] bytes = null;

        try {

            JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(jasper);
            bytes = JasperRunManager.runReportToPdf(relatorio, param, new ConexaoBD().conectaBD());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(new Date());

            File arq = new File("C:\\Users\\jateixeira\\Desktop\\oficiosExport", Data + NomeMaterial + ".pdf"); //esse é o tipo novo que vao abrir 
            /*if (arq.exists()){
            arq.delete(); //
        }*/
            FileOutputStream fos = new FileOutputStream(arq);
            fos.write(bytes);
            fos.flush();
            fos.close();

            Desktop desk = Desktop.getDesktop();
            desk.open(arq);
        } catch (JRException e) {
            e.printStackTrace();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotaSaida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NotaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
