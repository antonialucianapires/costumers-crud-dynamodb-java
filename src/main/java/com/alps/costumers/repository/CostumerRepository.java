package com.alps.costumers.repository;

import java.util.List;
import java.util.Optional;

import com.alps.costumers.document.Costumer;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CostumerRepository extends CrudRepository<Costumer, String> {

    List<Costumer> findByCompanyName(String companyName);
    Optional<Costumer> findByCompanyDocumentNumber(String companyDocumentNumber);
    
}
