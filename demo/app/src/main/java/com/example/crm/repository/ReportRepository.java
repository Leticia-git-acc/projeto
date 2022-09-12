package com.example.crm.repository;

import com.example.crm.model.Cliente;
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
public class ReportRepository {
    @Autowired
    ClienteRepository cliente;
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\l.cristina.rossato\\OneDrive - Accenture\\Desktop\\crm-api2";
        List<Cliente> clients=cliente.findAll();
        File file= ResourceUtils.getFile("classpath:client.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clients);
        Map<String, Object> paramaters = new HashMap<>();
        paramaters.put("createdBy","Letícia Rossato");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramaters,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\cliente.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\cliente.pdf");
        }
        return "report generated in path > " + path;
    }




}
