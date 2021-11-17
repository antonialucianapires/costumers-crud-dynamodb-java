package com.alps.costumers.resource;

import java.util.List;

import javax.validation.Valid;

import com.alps.costumers.document.Costumer;
import com.alps.costumers.dto.CostumerDTO;
import com.alps.costumers.service.CostumerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/costumers")
public class CostumerController {

    private final CostumerService costumerService;

    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @PostMapping
    public ResponseEntity<Costumer> newCostumer(@Valid @RequestBody CostumerDTO costumerDTO) {

        Costumer costumer = costumerService.saveCostumer(costumerDTO);

        return new ResponseEntity<>(costumer, HttpStatus.OK);
    }

    @GetMapping("/{companyName}")
    public ResponseEntity<List<Costumer>> findCostumerByName(@PathVariable("companyName") String companyName) {
        return ResponseEntity.ok(costumerService.findByCompanyName(companyName));
    }

    @GetMapping
    public ResponseEntity<List<Costumer>> allCostumers() {
        return ResponseEntity.ok(costumerService.findAllCostumers());
    }

    @PutMapping("/{companyDocumentNumber}")
    public ResponseEntity<Costumer> updateCostumer(@Valid @RequestBody CostumerDTO costumerDTO,
            String companyDocumentNumber) {
        return ResponseEntity.ok(costumerService.updateCostumer(companyDocumentNumber, costumerDTO));
    }

    @DeleteMapping("/{companyName}")
    public ResponseEntity<Costumer> disableCostumer(@PathVariable("companyName") String companyName) {
        return ResponseEntity.ok(costumerService.disableCostumer(companyName));
    }

}
