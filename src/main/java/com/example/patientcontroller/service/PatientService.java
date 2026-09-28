package com.example.patientcontroller.service;

import com.example.patientcontroller.dto.request.PatientCreateDTO;
import com.example.patientcontroller.entity.Patient;
import com.example.patientcontroller.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient createPatient(PatientCreateDTO patientCreateDTO) {
        Patient patient = new Patient();
        patient.setFullName(patientCreateDTO.getFullName());
        patient.setAge(patientCreateDTO.getAge());
        patient.setPhoneNumber(patientCreateDTO.getPhoneNumber());
        patient.setAddress(patientCreateDTO.getAddress());
        return patientRepository.save(patient);
    }
}
