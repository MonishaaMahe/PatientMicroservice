package com.sample.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
class Diagnoses {
    private String primaryDiagnosis;
    private String secondDiagnosis;
    private String thirdDiagnosis;
}
