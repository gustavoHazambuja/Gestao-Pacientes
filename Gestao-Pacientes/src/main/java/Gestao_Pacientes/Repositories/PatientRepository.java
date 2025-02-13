package Gestao_Pacientes.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Gestao_Pacientes.Entities.Patient;
import Gestao_Pacientes.Entities.PatientStatus;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    
    Page<Patient> findPatientByStatus(PatientStatus status, Pageable pageable);
}
