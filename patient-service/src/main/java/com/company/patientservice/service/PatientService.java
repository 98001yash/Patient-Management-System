package com.company.patientservice.service;


import com.company.patientservice.dto.PatientRequestDto;
import com.company.patientservice.dto.PatientResponseDto;
import com.company.patientservice.exceptions.EmailAlreadyExistsException;
import com.company.patientservice.mapper.PatientMapper;
import com.company.patientservice.model.Patient;
import com.company.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDto> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDto).toList();
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto){
        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email " + "already exists"+ patientRequestDto.getEmail());
        }
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDto)
        );
        return PatientMapper.toDto(newPatient);


    }
}
