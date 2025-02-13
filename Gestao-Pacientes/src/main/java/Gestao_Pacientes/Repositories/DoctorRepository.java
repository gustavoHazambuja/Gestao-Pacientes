package Gestao_Pacientes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Gestao_Pacientes.Entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
}
