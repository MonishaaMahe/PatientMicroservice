package com.sample.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "patients") // This defines the Elasticsearch index name
public class PatientIndex {

    private String id;

    @Field(type = FieldType.Keyword)
    private String medicalRecordNumber;

    @Field(type = FieldType.Date)
    private LocalDate startOfCareDate;

    @Field(type = FieldType.Keyword)
    private String status;

    @Field(type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Keyword)
    private String sex;

    @Field(type = FieldType.Date)
    private LocalDate birthDate;

    @Field(type = FieldType.Keyword)
    private String maritalStatus;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Text)
    private String city;

    @Field(type = FieldType.Keyword)
    private String state;

    @Field(type = FieldType.Keyword)
    private String county;

    @Field(type = FieldType.Keyword)
    private String zipCode;

    @Field(type = FieldType.Keyword)
    private String email;

    @Field(type = FieldType.Keyword)
    private String mobile;

    @Field(type = FieldType.Object)
    private ReferralInformationEntity referralInformation;

    @Field(type = FieldType.Object)
    private DiagnosesEntity diagnoses;

    @Field(type = FieldType.Text)
    private String insuranceDetails;

    @Field(type = FieldType.Text)
    private String primaryPhysicianDetails;
}
