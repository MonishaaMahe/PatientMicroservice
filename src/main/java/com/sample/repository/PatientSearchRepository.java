package com.sample.repository;
import com.sample.domain.PatientIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PatientSearchRepository extends ElasticsearchRepository<PatientIndex, String> {
    List<PatientIndex> findByFirstNameContainingOrLastNameContainingOrMedicalRecordNumberContaining(
        String firstName, String lastName, String medicalRecordNumber);
}
