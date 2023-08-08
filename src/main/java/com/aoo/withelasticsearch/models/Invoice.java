package com.aoo.withelasticsearch.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Document(indexName = "invoices")
@Data
public class Invoice {
    @Id
    private String id;
    @Field(type = FieldType.Text, name = "name")
    private String name;
    @Field(type = FieldType.Text, name = "number")
    private String number;
    @Field(type = FieldType.Text, name = "amount")
    private Double amount;
}
