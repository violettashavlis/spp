package com.bsuir.spp.controller;

import com.bsuir.spp.service.impl.DocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class DocController {

    @Autowired
    private DocServiceImpl docServiceImpl;

    @GetMapping("/pdfCertificate/{id}")
    public ResponseEntity<Resource> pdfCertificate(@PathVariable int id) {
        Resource body = docServiceImpl.generatePdfCertificate(id);

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "CertificatePDF.pdf" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/xlsCertificate/{id}")
    public ResponseEntity<Resource> xlsCertificate(@PathVariable int id) {
        Resource body = docServiceImpl.generateXLSCertificate(id);

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "CertificateXLS.xls" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/csvCertificate/{id}")
    public ResponseEntity<Resource> csvCertificate(@PathVariable int id) {
        Resource body = docServiceImpl.generateCSVCertificate(id);

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "CertificateCSV.csv" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/pdfEquipments")
    public ResponseEntity<Resource> pdfEquipments() {
        Resource body = docServiceImpl.generatePDFEquipments();

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "EquipmentsPDF.pdf" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/xlsEquipments")
    public ResponseEntity<Resource> xlsEquipments() {
        Resource body = docServiceImpl.generateXLSEquipments();

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "EquipmentsXLS.xls" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/csvEquipments")
    public ResponseEntity<Resource> csvEquipments() {
        Resource body = docServiceImpl.generateCSVEquipments();

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "EquipmentsCSV.csv" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/pdfServices")
    public ResponseEntity<Resource> pdfServices() {
        Resource body = docServiceImpl.generatePDFServices();

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "ServicesPDF.pdf" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/xlsServices")
    public ResponseEntity<Resource> xlsServices() {
        Resource body = docServiceImpl.generateXLSEquipments();

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "ServicesXLS.xls" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/csvServices")
    public ResponseEntity<Resource> csvServices() {
        Resource body = docServiceImpl.generateCSVEquipments();

        if (body != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "ServicesCSV.csv" + "\"").body(body);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
