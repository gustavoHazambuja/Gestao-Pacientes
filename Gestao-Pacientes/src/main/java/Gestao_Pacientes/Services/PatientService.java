package Gestao_Pacientes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Gestao_Pacientes.Entities.Patient;
import Gestao_Pacientes.Entities.PatientStatus;
import Gestao_Pacientes.Exceptions.PatientException;
import Gestao_Pacientes.Repositories.PatientRepository;

@Service
public class PatientService {
    
    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Patient addPacient(Patient patient){

        return patientRepository.save(patient);
    }

    @Transactional(readOnly = true)
    public Page<Patient> getAllPacients(Pageable pageable){
        
        Page<Patient> result = patientRepository.findAll(pageable);

        return result;
    }

    @Transactional(readOnly = true)
    public Page<Patient> findPacientByStatus(PatientStatus status, Pageable pageable){

        return patientRepository.findPatientByStatus(status, pageable);
    }

    @Transactional
    public void deletePacientById(Long id){

        if(!patientRepository.existsById(id)){
            throw new PatientException("Paciente não encontrado com id" + id);
        }
        patientRepository.deleteById(id);
    }

    @Transactional
    public Patient updateStatus(PatientStatus status, Long id){

        if(!patientRepository.existsById(id)){
            throw new PatientException("Paciente não encontrado com id" + id);
        }

        Patient result = patientRepository.findById(id).get();

        result.setStatus(status);

        return patientRepository.save(result);
    }
}
