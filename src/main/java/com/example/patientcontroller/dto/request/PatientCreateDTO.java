package com.example.patientcontroller.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientCreateDTO {
    @NotBlank
    private String fullName;

    @NotNull
    @Min(1)
    private Integer age;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;
}
