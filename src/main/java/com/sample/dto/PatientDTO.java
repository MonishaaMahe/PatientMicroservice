package com.sample.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private String medicalRecordNumber;
    private LocalDate startOfCareDate;
    private String status;
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDate birthDate;
    private String maritalStatus;
    private String address;
    private String city;
    private String state;
    private String county;
    private String zipCode;
    private String email;
    private String mobile;
    private ReferralInformationDTO referralInformation;
    private DiagnosesDTO diagnoses;
    private String insuranceDetails;
    private String primaryPhysicianDetails;
}

