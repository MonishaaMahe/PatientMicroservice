package com.sample.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class ReferralInformationEntity {

    @Field(type = FieldType.Text)
    private String referrerName;

    @Field(type = FieldType.Text)
    private String referrerEmail;

    @Field(type = FieldType.Text)
    private String referrerMobile;
}
