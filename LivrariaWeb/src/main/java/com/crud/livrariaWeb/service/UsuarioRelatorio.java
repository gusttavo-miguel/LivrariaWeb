package com.crud.livrariaWeb.service;

import com.crud.livrariaWeb.model.Funcionarios;
import com.crud.livrariaWeb.repository.UsuarioRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioRelatorio {


    @Autowired
    private UsuarioRepository usuarioRepository;


    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\gustavo.miguel.silva\\Documents\\Relatorios";
        List<Funcionarios> usuarios = usuarioRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:usuarios.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usuarios);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\usuarios.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\usuarios.pdf");
        }

        return "Relatório gerado em: " + path;
    }
}