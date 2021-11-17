package com.alps.costumers.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.alps.costumers.document.Costumer;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CostumerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @JsonProperty("company_document_number")
    @NotNull
    @NotBlank
    private String companyDocumentNumber;

    @JsonProperty("phone_number")
    @NotNull
    @NotBlank
    private String phoneNumber;

    @JsonProperty("active")
    private Boolean active;

    public Costumer costumerDTOToCostumer() {
        return new Costumer(this.companyName, this.companyDocumentNumber, this.phoneNumber, true);
    }

}
