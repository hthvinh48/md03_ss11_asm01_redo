package com.example.patientcontroller.controller;

import com.example.patientcontroller.dto.request.PatientCreateDTO;
import com.example.patientcontroller.dto.response.ApiResponse;
import com.example.patientcontroller.entity.Patient;
import com.example.patientcontroller.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Patient>> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(
                "SUCCESS", "fetched data successfully", patientService.getPatientById(id)
        ));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Patient>> addPatient(
            @Valid @RequestBody PatientCreateDTO patientCreateDTO
    ) {
        log.info("Adding patient: {}", patientCreateDTO.getFullName());

        if (patientCreateDTO.getAge() > 120) log.warn("Patient age is unusually high: {}",  patientCreateDTO.getAge());

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                "SUCCESS", "new patient created", patientService.createPatient(patientCreateDTO)
        ));
    }
}
