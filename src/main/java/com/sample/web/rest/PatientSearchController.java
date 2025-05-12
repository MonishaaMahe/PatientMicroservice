package com.sample.web.rest;

import com.sample.domain.PatientIndex;
import com.sample.repository.PatientSearchRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientSearchController {

    private final PatientSearchRepository repository;

    public PatientSearchController(PatientSearchRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/search")
    public List<PatientIndex> search(@RequestParam String keyword) {
        return repository.findByFirstNameContainingOrLastNameContainingOrMedicalRecordNumberContaining(
            keyword, keyword, keyword);
    }
}
