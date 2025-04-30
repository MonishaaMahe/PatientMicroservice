package com.sample.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
class ReferralInformation {
    private String referrerName;
    private String referrerEmail;
    private String referrerMobile;
}
