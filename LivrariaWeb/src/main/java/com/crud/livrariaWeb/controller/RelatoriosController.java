package com.crud.livrariaWeb.controller;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class RelatoriosController implements ActionListener {

    private JTextField tfusuarios;

    public RelatoriosController(JTextField tfusuarios){
        this.tfusuarios = tfusuarios;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        geraRelatorio();
    }

    private void geraRelatorio() {
        String erro = "";
        String usuarios = tfusuarios.getText();
        String jasper = "C:\\Users\\gustavo.miguel.silva\\JaspersoftWorkspace\\MyReports\\Usuarios.jasper";

        HashMap <String,Object> param = new  HashMap <String,Object> ();
        param.put("Usuarios", usuarios);

        byte [] bytes = null;

        try {
            JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(jasper);
            bytes = JasperRunManager.runReportToPdf(relatorio, param);

            File arq = new File("C:\\Users\\gustavo.miguel.silva\\Documents",usuarios + ".pdf" );
            if (arq.exists()){
                arq.delete();
            }

            FileOutputStream fos = new FileOutputStream(arq);
            fos.write(bytes);
            fos.flush();
            fos.close();

            Desktop desk = Desktop.getDesktop();
            desk.open(arq);

        } catch (JRException | IOException e) {
            erro = e.getMessage();
            JOptionPane.showMessageDialog(null, erro);
        }


    }
}