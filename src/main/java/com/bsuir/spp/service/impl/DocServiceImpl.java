package com.bsuir.spp.service.impl;


import com.bsuir.spp.model.Certificate;
import com.bsuir.spp.model.Equipment;
import com.bsuir.spp.model.ServiceEntity;
import com.bsuir.spp.service.*;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.pdf.BaseFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.apache.poi.ss.util.CellUtil.createCell;

@Service
public class DocServiceImpl implements DocService {

    private final CertificateService certificateService;
    private final EquipmentService equipmentService;
    private final ServiceService service;

    @Autowired
    public DocServiceImpl(CertificateService certificateService, UserService userService, EquipmentService equipmentService, ServiceService service) {
        this.certificateService = certificateService;
        this.equipmentService = equipmentService;
        this.service = service;
    }

    @Override
    public Resource generatePdfCertificate(int id) {
        Certificate info = certificateService.findById(id);
        if (info == null) {
            return null;
        }
        return createPdf((doc -> {
            try {
                PdfFont font = PdfFontFactory.createFont("src/main/resources/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

                Paragraph paragraph = new Paragraph("Certificate")
                        .setItalic()
                        .setMarginBottom(20)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFont(font)
                        .setFontSize(40);
                doc.add(paragraph);

                paragraph = new Paragraph()
                        .setFont(font)
                        .setFontSize(20)
                        .add(String.format("%s %n",info.getDoc()))
                        .add(String.format("%s %s %s",info.getName(),info.getDate(),info.getValidity()));
                doc.add(paragraph);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public Resource generateXLSCertificate(int id) {
        Certificate info = certificateService.findById(id);
        if (info == null) {
            return null;
        }
        return createXLS((sheet, style) -> {
            HSSFRow[] rows = new HSSFRow[3];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }

            int i = 0;
            createCell(rows[i++], 0, "Имя", style);
            createCell(rows[i++], 0, "Дата", style);
            createCell(rows[i++], 0, "Валиден", style);

            i = 0;
            createCell(rows[i++], 1, info.getName(), style);
            createCell(rows[i++], 1, info.getDate().toString(), style);
            createCell(rows[i++], 1, info.getValidity().toString(), style);

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
        });
    }

    @Override
    public Resource generateCSVCertificate(int id) {
        Certificate info =  certificateService.findById(id);
        if (info == null) {
            return null;
        }
        return createCSV(() -> String.format("%s;%s;%s;%s;%s;", info.getName(), info.getDate(), info.getValidity()));
    }

    @Override
    public Resource generatePDFEquipments() {
        List<Equipment> list = equipmentService.findAll();
        return createPdf(((Document doc) -> {
            try {
                PdfFont font = PdfFontFactory.createFont("src/main/resources/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Paragraph paragraph = null;
                paragraph = new Paragraph(String.format("Список оборудования"))
                        .setItalic()
                        .setMarginBottom(20)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFont(font)
                        .setFontSize(40);
                doc.add(paragraph);

                paragraph = new Paragraph()
                            .setFont(font)
                            .setFontSize(20);
                for (Equipment equipment : list) {
                    paragraph.add(String.format("Номер: %s, Марка: %s, Модель: %s, Имя: %s, Год: %s %n",equipment.getStateNumber(), equipment.getMark(),equipment.getModel(),equipment.getName(),equipment.getIssureYear().toString()));
                }
                doc.add(paragraph);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public Resource generateXLSEquipments() {
        List<Equipment> list = equipmentService.findAll();
        return createXLS((sheet, style) -> {
            HSSFRow[] rows = new HSSFRow[list.size() + 1];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }
            createCell(rows[0], 0, "Номер", style);
            createCell(rows[0], 1, "Марка", style);
            createCell(rows[0], 2, "Модель", style);
            createCell(rows[0], 3, "Имя", style);
            createCell(rows[0], 4, "Год", style);


            for (int i = 0; i < list.size(); i++) {
                createCell(rows[i + 1], 0, list.get(i).getStateNumber(), style);
                createCell(rows[i + 1], 1, list.get(i).getMark(), style);
                createCell(rows[i + 1], 2, list.get(i).getModel(), style);
                createCell(rows[i + 1], 3, list.get(i).getName(), style);
                createCell(rows[i + 1], 4, list.get(i).getIssureYear().toString(), style);

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
        });
    }

    @Override
    public Resource generateCSVEquipments() {
        return createCSV(() -> {
            List<Equipment> list = equipmentService.findAll();
            StringBuffer buf = new StringBuffer();
            for (Equipment equipment : list) {
                buf.append(equipment.getStateNumber() + ";" + equipment.getMark() + ";"+ equipment.getModel() + ";"+ equipment.getName() + ";"+ equipment.getIssureYear() + ";");
            }
            return buf.toString();
        });
    }

    @Override
    public Resource generatePDFServices() {
        List<ServiceEntity> list = service.findAll();
        return createPdf(((Document doc) -> {
            try {
                PdfFont font = PdfFontFactory.createFont("src/main/resources/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Paragraph paragraph = null;
                paragraph = new Paragraph(String.format("Услуги"))
                        .setItalic()
                        .setMarginBottom(20)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFont(font)
                        .setFontSize(40);
                doc.add(paragraph);

                paragraph = new Paragraph()
                            .setFont(font)
                            .setFontSize(20);
                for (ServiceEntity serviceEntity : list) {
                    paragraph.add(String.format("Название: %s, Цена: %s, Время: %s%n Описание: %s%n",serviceEntity.getName(), serviceEntity.getPrice(),serviceEntity.getTime(),serviceEntity.getDescription()));
                }
                doc.add(paragraph);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public Resource generateXLSServices() {
        List<ServiceEntity> list = service.findAll();
        return createXLS((sheet, style) -> {
            HSSFRow[] rows = new HSSFRow[list.size() + 1];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = sheet.createRow(i);
            }
            createCell(rows[0], 0, "Название", style);
            createCell(rows[0], 1, "Цена", style);
            createCell(rows[0], 2, "Время", style);
            createCell(rows[0], 3, "Людей", style);

            for (int i = 0; i < list.size(); i++) {
                createCell(rows[i + 1], 0, list.get(i).getName(), style);
                createCell(rows[i + 1], 1, String.valueOf(list.get(i).getPrice()), style);
                createCell(rows[i + 1], 2, String.valueOf(list.get(i).getTime()), style);
                createCell(rows[i + 1], 3, String.valueOf(list.get(i).getCountPeople()), style);

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
        });
    }

    @Override
    public Resource generateCSVServices() {
        return createCSV(() -> {
            List<ServiceEntity> list = service.findAll();
            StringBuffer buf = new StringBuffer();
            for (ServiceEntity serviceEntity : list) {
                buf.append(serviceEntity.getName() + ";" + serviceEntity.getPrice() + ";"+ serviceEntity.getTime() + ";"+ serviceEntity.getCountPeople() + ";");
            }
            return buf.toString();
        });
    }

    public Resource createPdf(Consumer<Document> c) {

        Document document;
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(stream);
            PdfDocument pdf = new PdfDocument(writer);
            document = new Document(pdf, PageSize.A4);
            createPdfTemplate(document);
            c.accept(document);
            document.close();
            return new ByteArrayResource(stream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Resource createCSV(Supplier<String> c) {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
             Writer writer = new OutputStreamWriter(stream)) {
            writer.append(c.get());
            writer.flush();
            return new ByteArrayResource(stream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Resource createXLS(BiProcedure<HSSFSheet, CellStyle> p) {

        try (HSSFWorkbook workbook = new HSSFWorkbook();
             ByteArrayOutputStream stream = new ByteArrayOutputStream()) {

            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            CellStyle style = createStyle(workbook, sheet);
            p.accept(sheet, style);
            workbook.write(stream);
            return new ByteArrayResource(stream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createPdfTemplate(Document document) {
        try {
            Image logo = new Image(ImageDataFactory.create("src/main/resources/logo.jpg"));
            Paragraph paragraph = new Paragraph().add(logo);
            document.add(paragraph);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private CellStyle createStyle(HSSFWorkbook workbook, HSSFSheet sheet) {

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("Times New Roman");
        style.setFont(font);
        style.setWrapText(true);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.TOP);
        return style;
    }


}