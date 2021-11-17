package com.alps.costumers.service;

import java.util.List;
import com.alps.costumers.document.Costumer;
import com.alps.costumers.dto.CostumerDTO;

public interface CostumerService {
    Costumer saveCostumer(CostumerDTO costumerDTO);
    List<Costumer> findAllCostumers();
    List<Costumer> findByCompanyName(String companyName);
    Costumer updateCostumer(String companyDocumentNumber, CostumerDTO costumerDTO);
    Costumer disableCostumer(String companyDocumentNumber);
}
