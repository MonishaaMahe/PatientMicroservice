package com.sample.web.rest;

import com.sample.config.VaultDataConfig;
import com.sample.dto.PatientDTO;
import com.sample.dto.UserDto;
import com.sample.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    private final PatientService service;

    @Autowired
    private VaultDataConfig vaultDataConfig;

    @GetMapping("/vaultsecret")
    public String getVaultData()
    {
        return vaultDataConfig.getName();
    }

    @Value("${custom.message:Default message if not found}")
    private String message;


    @GetMapping("/message")
    public String getMessageFromConfig() {
        return message;
    }

    @GetMapping("/check-user")
    public ResponseEntity<UserDto> checkUser() {
        UserDto user = service.getUserMethod();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable UUID id, @RequestBody PatientDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable UUID id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<PatientDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/data")
    public ResponseEntity<List<PatientDTO>> getAllData() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/get-user/{id}")
    public ResponseEntity<PatientDTO> getUser(@PathVariable String id) {
        return ResponseEntity.ok(service.getPatient(id));
    }*/
}

