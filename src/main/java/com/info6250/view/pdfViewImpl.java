/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info6250.view;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author adityaillur
 */

public class pdfViewImpl extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document dc, PdfWriter wtr, HttpServletRequest hsreq, HttpServletResponse hsresp) throws Exception {
        
        Font red_times_18_bold         = FontFactory.getFont(FontFactory.TIMES    , 24, Font.BOLDITALIC, new Color(255, 0,   0));
        Font blue_helvetica_13_normal  = FontFactory.getFont(FontFactory.HELVETICA, 13, Font.NORMAL    , new Color(  0, 0, 255));
        Font black_helvetica_12_normal = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL    , new Color(  0  ,0,  0));
        Font black_helvetica_11_normal = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL    , new Color(  0  ,0,  0));

        
        Paragraph para1 = new Paragraph("Book System - Aditya Illur (002776756)", red_times_18_bold);
        Paragraph para2 = new Paragraph("Web 2.0 Application where users Login/Sign-up and operate on Books", blue_helvetica_13_normal);
        Paragraph para3 = new Paragraph("-------------------------------------------------------------------------------‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎‎", black_helvetica_12_normal);
        Paragraph para4 = new Paragraph("Tech Stack:", black_helvetica_12_normal);
        Paragraph para5 = new Paragraph("- SpringMVC Architecture", black_helvetica_11_normal);
        Paragraph para6 = new Paragraph("- Hibernate ", black_helvetica_11_normal);
        Paragraph para7 = new Paragraph("- Controllers", black_helvetica_11_normal);
        Paragraph para8 = new Paragraph("- DAO Pattern ", black_helvetica_11_normal);
        Paragraph para9 = new Paragraph("- POJO Class ", black_helvetica_11_normal);
        Paragraph para10 = new Paragraph("- Session Handling ", black_helvetica_11_normal);
        Paragraph para11 = new Paragraph("- Annotations ", black_helvetica_11_normal);
        Paragraph para12 = new Paragraph("- Get, Post Mappings ", black_helvetica_11_normal);
        Paragraph para13 = new Paragraph("- Exception Handling & Validations ", black_helvetica_11_normal);
        Paragraph para14 = new Paragraph("- MySQL ", black_helvetica_11_normal);

        
        dc.add(para1);
        dc.add(para2);
        dc.add(para3);
        dc.add(para4);
        dc.add(para5);
        dc.add(para6);
        dc.add(para7);
        dc.add(para8);
        dc.add(para9);
        dc.add(para10);
        dc.add(para11);
        dc.add(para12);
        dc.add(para13);
        dc.add(para14);
        
        dc.close();
        
    }
    
}
