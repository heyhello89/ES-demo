package com.okestro.elk.demo.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName="spring_test")
public class SpringTest {

    @Id
    private String id;
    private String name;
    private String message;

    @Field(name = "@timestamp", type = FieldType.Date)
    private Date datetime;
}
