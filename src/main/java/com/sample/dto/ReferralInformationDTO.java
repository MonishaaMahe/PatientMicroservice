package com.sample.dto;

import lombok.Data;

import java.io.Serializable;

@Data
class ReferralInformationDTO implements Serializable {
    private String referrerName;
    private String referrerEmail;
    private String referrerMobile;
}
