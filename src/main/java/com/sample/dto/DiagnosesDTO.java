package com.sample.dto;

import lombok.Data;

import java.io.Serializable;

@Data
class DiagnosesDTO implements Serializable {
    private String primaryDiagnosis;
    private String secondDiagnosis;
    private String thirdDiagnosis;
}
