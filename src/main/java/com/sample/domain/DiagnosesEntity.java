package com.sample.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class DiagnosesEntity {

    @Field(type = FieldType.Text)
    private String primaryDiagnosis;

    @Field(type = FieldType.Text)
    private String secondDiagnosis;

    @Field(type = FieldType.Text)
    private String thirdDiagnosis;
}
