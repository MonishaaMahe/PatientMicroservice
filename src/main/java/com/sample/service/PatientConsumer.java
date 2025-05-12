package com.sample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConnectionFactory;
import com.sample.domain.DiagnosesEntity;
import com.sample.domain.PatientIndex;
import com.sample.domain.ReferralInformationEntity;
import com.sample.dto.DiagnosesDTO;
import com.sample.dto.PatientDTO;
import com.sample.dto.ReferralInformationDTO;
import com.sample.repository.PatientSearchRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientConsumer {

    private final ObjectMapper objectMapper;
    private final PatientSearchRepository repository;


    public PatientConsumer(ObjectMapper objectMapper, PatientSearchRepository repository) {
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    @RabbitListener(queues = "patient-queue")
    public void receive(PatientDTO patientDTO) {
        try {
           // PatientDTO dto = objectMapper.readValue(message, PatientDTO.class);
            PatientIndex index = mapToIndex(patientDTO);
            repository.save(index);
        } catch (Exception e) {
            e.printStackTrace(); // Add logging
        }
    }

    private PatientIndex mapToIndex(PatientDTO dto) {
        PatientIndex index = new PatientIndex();
        index.setId(UUID.randomUUID().toString());
        index.setMedicalRecordNumber(dto.getMedicalRecordNumber());
        index.setFirstName(dto.getFirstName());
        index.setLastName(dto.getLastName());
        index.setBirthDate(dto.getBirthDate());
        index.setAddress(dto.getAddress());
        index.setCity(dto.getCity());
        index.setState(dto.getState());
        index.setZipCode(dto.getZipCode());
        index.setEmail(dto.getEmail());
        //index.setPhoneNumber(dto.getPhoneNumber());
        index.setBirthDate(dto.getBirthDate());
        index.setInsuranceDetails(dto.getInsuranceDetails());
        index.setMaritalStatus(dto.getMaritalStatus());
        index.setPrimaryPhysicianDetails(dto.getPrimaryPhysicianDetails());
        ReferralInformationEntity referralInformation = new ReferralInformationEntity();
        ReferralInformationDTO referralInformationDTO = dto.getReferralInformation();
        referralInformation.setReferrerEmail(referralInformationDTO.getReferrerEmail());
        referralInformation.setReferrerName(referralInformationDTO.getReferrerName());
        referralInformation.setReferrerMobile(referralInformationDTO.getReferrerMobile());
        index.setReferralInformation(referralInformation);
        DiagnosesEntity diagnosesEntity = new DiagnosesEntity();
        DiagnosesDTO diagnosesDTO = dto.getDiagnoses();
        diagnosesEntity.setPrimaryDiagnosis(diagnosesDTO.getPrimaryDiagnosis());
        diagnosesEntity.setSecondDiagnosis(diagnosesDTO.getSecondDiagnosis());
        diagnosesEntity.setThirdDiagnosis(diagnosesDTO.getThirdDiagnosis());
        index.setDiagnoses(diagnosesEntity);
        return index;
    }
}

