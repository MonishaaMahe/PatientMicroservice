package com.sample.service;

import com.sample.domain.Patient;
import com.sample.dto.PatientDTO;
import com.sample.dto.UserDto;
import com.sample.repository.PatientRepository;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private final PatientRepository repository;

    @Autowired
    private final ModelMapper mapper;

    @Autowired
    private final UserClient userClient;

   /* public PatientService(PatientService repository, ModelMapper mapper, UserClient userClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.userClient = userClient;
    }*/

   /* @Autowired
    private RestTemplate restTemplate;

    public PatientDTO getPatient(String id) {
        String url = "http://user-service/api/users/" + id;
        return restTemplate.getForObject(url, PatientDTO.class);
    }*/

    public UserDto getUserMethod() {
        UserDto user = userClient.getUserById(1L);
        System.out.println("Fetched user: " + user.getUsername());
        return  user;
    }



    public PatientDTO create(PatientDTO dto) {
        Patient patient = mapper.map(dto, Patient.class);
        return mapper.map(repository.save(patient), PatientDTO.class);
    }

    public PatientDTO update(Long id, PatientDTO dto) {
        Patient existing = repository.findById(id).orElseThrow();
        mapper.map(dto, existing);
        return mapper.map(repository.save(existing), PatientDTO.class);
    }

    public Optional<PatientDTO> getById(Long id) {
        return repository.findById(id).map(p -> mapper.map(p, PatientDTO.class));
    }

    public Page<PatientDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(p -> mapper.map(p, PatientDTO.class));
    }

    public List<PatientDTO> getAll() {
        return repository.findAll().stream().map(p -> mapper.map(p, PatientDTO.class)).toList();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
