package com.sample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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

    @Embedded
    private ReferralInformation referralInformation;

    @Embedded
    private Diagnoses diagnoses;

    @Column(length = 512)
    private String insuranceDetails;

    @Column(length = 512)
    private String primaryPhysicianDetails;


}
