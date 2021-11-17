package com.alps.consumers.document;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBTable(tableName = "Costumer")
public class Costumer implements Serializable {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    @JsonIgnore
    private String id;

    @DynamoDBAttribute(attributeName = "company_name")
    @JsonProperty("company_name")
    private String companyName;

    @DynamoDBAttribute(attributeName = "company_document_number")
    @JsonProperty("company_document_number")
    private String companyDocumentNumber;

    @DynamoDBAttribute(attributeName = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @DynamoDBAttribute(attributeName = "active")
    @JsonProperty("active")
    private Boolean active;

    public Costumer() {
    }

    public Costumer(String companyName, String companyDocumentNumber, String phoneNumber, Boolean active) {
        this.companyName = companyName;
        this.companyDocumentNumber = companyDocumentNumber;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

}
