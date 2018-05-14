package com.bsuir.spp.service;

import org.springframework.core.io.Resource;

public interface DocService {
    Resource generatePdfCertificate(int id);

    Resource generateXLSCertificate(int id);

    Resource generateCSVCertificate(int id);

    Resource generatePDFEquipments();

    Resource generateXLSEquipments();

    Resource generateCSVEquipments();

    Resource generatePDFServices();

    Resource generateXLSServices();

    Resource generateCSVServices();
}
