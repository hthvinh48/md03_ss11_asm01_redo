package com.example.patientcontroller.repository;

import com.example.patientcontroller.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
